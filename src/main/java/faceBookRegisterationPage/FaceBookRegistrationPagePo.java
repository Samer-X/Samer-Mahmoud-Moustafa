package faceBookRegisterationPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FaceBookRegistrationPagePo {


    @FindBy(name = "firstname")
    WebElement firstNameField;

    @FindBy(name = "lastname")
    WebElement lastNameField;

    @FindBy(xpath = "//input[@aria-label ='Mobile number or email address']")
    WebElement emailField;

    @FindBy(name = "reg_email_confirmation__")
    WebElement reEnterEmailField;


    @FindBy(id = "password_step_input")
    WebElement passwordField;

    @FindBy(id = "day")
    WebElement birthDay;

    @FindBy(id = "month")
    WebElement birthMonth;

    @FindBy(id = "year")
    WebElement birthYear;

    @FindBy(xpath = "//label[text()='Male']//following-sibling::input")
    WebElement maleRadioButton;


    @FindBy(xpath = "//label[text()='Female']//following-sibling::input")
    WebElement femaleRadioButton;

    @FindBy(xpath = "//button[text()='Sign Up']")
    WebElement signUpButton;


    @FindBy(xpath = "//a[text()='Create New Account']")
    WebElement createNewAccountButton;

    @FindBy(xpath = "//span[text()='Create a Story']")
    WebElement homePage;

}
