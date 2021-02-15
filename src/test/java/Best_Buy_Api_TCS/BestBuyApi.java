package Best_Buy_Api_TCS;

import Driver.DriverSetup;
import commonUtils.CommonConstants;

import static io.restassured.RestAssured.*;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BestBuyApi extends DriverSetup {

    String productID;
    String editedNameTest = "Edited Name Test";

    @Test(priority = 1)
    void ListAllProducts() {
        baseURI = CommonConstants.apiURL;
        given()
                .when()
                .get("/products").then().statusCode(200);
    }

    @Test(priority = 2)
    void CreateNewProduct() {

        JSONObject requestString = new JSONObject();

        requestString.put("name", "name test");
        requestString.put("type", "type test");
        requestString.put("price", 200);
        requestString.put("shipping", 200);
        requestString.put("upc", "upc test");
        requestString.put("description", "description test");
        requestString.put("model", "model test");

        baseURI = CommonConstants.apiURL;
        Response response = given().body(requestString.toJSONString())
                .when().header("Content-Type", "application/json")
                .post("/products");

        JsonPath jsonPathEvaluator = response.jsonPath();
        productID = jsonPathEvaluator.get("id").toString();
    }

    @Test(priority = 3)
    void editCreatedProduct() {

        JSONObject requestString = new JSONObject();

        requestString.put("name", editedNameTest);
        requestString.put("type", "Edited type test");
        requestString.put("price", 400);
        requestString.put("shipping", 400);
        requestString.put("upc", "Edited upc test");
        requestString.put("description", "Edited description test");
        requestString.put("model", "Edited model test");

        baseURI = CommonConstants.apiURL;
        given().body(requestString.toJSONString())
                .when().header("Content-Type", "application/json")
                .patch("/products/" + productID).then().statusCode(200);
    }

    @Test(priority = 4)
    void getCreatedProductByID() {
        baseURI = CommonConstants.apiURL;
        String nameAfterEdit = given()
                .when().header("Content-Type", "application/json")
                .get("/products/" + productID).then().statusCode(200).extract().path("name");
        Assert.assertEquals(nameAfterEdit, editedNameTest);
    }

    @Test(priority = 5)
    void DeleteCreatedProductByID() {
        baseURI = CommonConstants.apiURL;
        given().delete("/products")
                .then()
                .statusCode(200);
    }

    @Test(priority = 5)
    void verifyCreatedProductIsDeleted() {
        baseURI = CommonConstants.apiURL;
        given()
                .when().header("Content-Type", "application/json")
                .get("/products/" + productID).then().statusCode(404);
    }
}
