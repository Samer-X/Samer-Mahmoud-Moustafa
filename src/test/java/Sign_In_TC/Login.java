package Sign_In_TC;

import Driver.DriverSetup;
import commonUtils.CommonConstants;
import commonUtils.ExcelHelper;
import faceBookLoginPage.FaceBookLoginPageHelper;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Login extends DriverSetup {
    String projectPath = System.getProperty("user.dir");
    ExcelHelper excelHelper = new ExcelHelper(projectPath + CommonConstants.excelPath, CommonConstants.sheet1);
    String email = excelHelper.getEmail(1);
    String password = excelHelper.getPassword(1);
    FaceBookLoginPageHelper faceBookLoginPageHelper;

    @BeforeTest()
    void initiate() {
        DriverSetup.driverConf();
        driver.manage().window().maximize();
        faceBookLoginPageHelper = new FaceBookLoginPageHelper(driver);
        faceBookLoginPageHelper.openWebSite();
    }

    @Test(priority = 1)
    void loginUsingValidEmailAndPassword() {
        faceBookLoginPageHelper.login(email, password);
        faceBookLoginPageHelper.verifyHomePageIsOpened();
    }

    @AfterTest()
    void closure() {
        driver.close();
        driver.quit();
    }
}
