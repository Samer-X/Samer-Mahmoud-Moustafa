package Register_TC;

import Driver.DriverSetup;
import commonUtils.CommonConstants;
import commonUtils.ExcelHelper;
import enums.Enums;
import faceBookRegisterationPage.FaceBookRegistrationPageHelper;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Register extends DriverSetup {
    String projectPath = System.getProperty("user.dir");
    ExcelHelper excelHelper = new ExcelHelper(projectPath + CommonConstants.excelPath, CommonConstants.sheet1);
    String email = excelHelper.getEmail(2);
    String password = excelHelper.getPassword(2);
    String firstName = excelHelper.getFirstName(2);
    String surName = excelHelper.getLastName(2);

    FaceBookRegistrationPageHelper faceBookRegistrationPageHelper;

    @BeforeTest()
    void initiate() {
        DriverSetup.driverConf();
        driver.manage().window().maximize();
        faceBookRegistrationPageHelper = new FaceBookRegistrationPageHelper(driver);
        faceBookRegistrationPageHelper.openWebSite();
    }

    @Test(priority = 1)
    void registerUsingValidData() {
        faceBookRegistrationPageHelper.clickCreateNeAccountButton();
        faceBookRegistrationPageHelper.enterFirstName(firstName);
        faceBookRegistrationPageHelper.enterSurName(surName);
        faceBookRegistrationPageHelper.enterEmail(email);
        faceBookRegistrationPageHelper.reEnterEmail(email);
        faceBookRegistrationPageHelper.enterPassword(password);
        faceBookRegistrationPageHelper.enterDateOfBirth("11", "march", "1994");
        faceBookRegistrationPageHelper.enterGender(Enums.Gender.male);
        faceBookRegistrationPageHelper.clickSignUpButton();
        faceBookRegistrationPageHelper.verifyHomePageIsOpened();
    }

    @AfterTest()
    void closure() {
        driver.close();
        driver.quit();
    }
}
