package faceBookLoginPage;

import commonUtils.CommonHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class FaceBookLoginPageHelper extends FaceBookLoginPagePo {

    public FaceBookLoginPageHelper(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void openWebSite() {
        CommonHelper.openWebPage(FaceBookLoginPageConstants.url);
    }

    public void enterEmail(String email) {
        CommonHelper.sendText(emailField, email);
    }

    public void enterPassword(String password) {
        CommonHelper.sendText(passwordField, password);
    }

    public void clickLoginButton() {
        CommonHelper.clickWhenReady(loginButton);
    }

    public void verifyHomePageIsOpened() {
        CommonHelper.verifyElementAppears(homePage);
    }

    public void login(String email, String password) {
        this.enterEmail(email);
        this.enterPassword(password);
        this.clickLoginButton();
    }
}
