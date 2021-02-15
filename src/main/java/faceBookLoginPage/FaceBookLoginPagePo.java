package faceBookLoginPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FaceBookLoginPagePo {

    @FindBy(id = "email")
    WebElement emailField;

    @FindBy(id = "pass")
    WebElement passwordField;

    @FindBy(name = "login")
    WebElement loginButton;

    @FindBy(xpath = "//span[contains(text(),'Welcome to Facebook')]")
    WebElement homePage;


}
