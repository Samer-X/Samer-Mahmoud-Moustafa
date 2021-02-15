package commonUtils;

import Driver.DriverSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonHelper {

    static WebDriver driver = DriverSetup.getDriver();

    public static void openWebPage(String url) {
        driver.navigate().to(url);
    }

    public static void clickWhenReady(WebElement po) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(po)).click();
    }

    public static void verifyElementAppears(WebElement Po) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(Po));
    }

    public static void verifyElementNotAppear(WebElement Po) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.invisibilityOf(Po));
    }

    public static void sendText(WebElement po, String Text) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(po)).sendKeys(Text);
    }

    public static String getText(WebElement Po) {
        WebElement element = Po;
        String text = element.getText();
        return text;
    }

    public static void clickEnter(WebElement po) {
        po.sendKeys(Keys.ENTER);
    }

    public static void refreshPage() {
        driver.navigate().refresh();
    }

    public static WebElement findElementByText(String tagName, String text) {
        return driver.findElement(By.xpath("//" + tagName + "[text()=" + text+"]"));
    }

}