package faceBookRegisterationPage;

import commonUtils.CommonHelper;
import enums.Enums;
import faceBookLoginPage.FaceBookLoginPageConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class FaceBookRegistrationPageHelper extends FaceBookRegistrationPagePo {


    public FaceBookRegistrationPageHelper(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void openWebSite() {
        CommonHelper.openWebPage(FaceBookLoginPageConstants.url);
    }


    public void clickCreateNeAccountButton() {
        CommonHelper.clickWhenReady(createNewAccountButton);
    }

    public void enterFirstName(String firstName) {
        CommonHelper.sendText(firstNameField, firstName);
    }

    public void enterSurName(String lastName) {
        CommonHelper.sendText(lastNameField, lastName);
    }

    public void enterEmail(String email) {
        CommonHelper.sendText(emailField, email);
    }

    public void reEnterEmail(String email) {
        CommonHelper.sendText(reEnterEmailField, email);
    }

    public void enterPassword(String password) {
        CommonHelper.sendText(passwordField, password);
    }

    public void enterDateOfBirth(String day, String month, String year) {
        CommonHelper.clickWhenReady(birthDay);
        CommonHelper.clickWhenReady(CommonHelper.findElementByText("option", day));
        CommonHelper.sendText(birthMonth, month);
        CommonHelper.clickEnter(birthMonth);
        CommonHelper.sendText(birthYear, year);
        CommonHelper.clickEnter(birthYear);
    }

    public void enterGender(Enums.Gender sex) {
        if (sex == Enums.Gender.male) {
            CommonHelper.clickWhenReady(maleRadioButton);
        } else if (sex == Enums.Gender.female) {
            CommonHelper.clickWhenReady(femaleRadioButton);

        }
    }

    public void clickSignUpButton() {
        CommonHelper.clickWhenReady(signUpButton);
    }


    public void verifyHomePageIsOpened() {
        CommonHelper.verifyElementAppears(homePage);
    }
}
