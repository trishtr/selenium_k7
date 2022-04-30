package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static api_learning.Urls.baseUrl;
import static api_learning.Urls.jsAlertPage;


public class JsAlert {

    private final static By jsAlertSel = By.cssSelector("[onclick=\"jsAlert()\"]");
    private final static By jsAlertConfirmSel = By.cssSelector("[onclick=\"jsConfirm()\"]");
    private final static By jsAlertPromptSel = By.cssSelector("[onclick=\"jsPrompt()\"]");
    private final static By resultSel = By.cssSelector("#result");


    public static void main(String[] args) {

            WebDriver driver = DriverFactory.getChromeDriver();
            try {
                driver.get(baseUrl.concat(jsAlertPage));

                WebElement triggerJsAlertBtn = null;
                Alert alert;
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

                //Alert
                triggerJsAlertBtn = driver.findElement(jsAlertSel);
                triggerJsAlertBtn.click();
                alert = wait.until(ExpectedConditions.alertIsPresent());
                System.out.println(alert.getText());
                alert.accept();
                System.out.println("Result: " + driver.findElement(resultSel).getText());

                //Confirm
                triggerJsAlertBtn = driver.findElement(jsAlertConfirmSel);
                triggerJsAlertBtn.click();
                alert = wait.until(ExpectedConditions.alertIsPresent());
                System.out.println(alert.getText());
                alert.dismiss();
                System.out.println("Result: " + driver.findElement(resultSel).getText());

                //prompt
                triggerJsAlertBtn = driver.findElement(jsAlertPromptSel);
                triggerJsAlertBtn.click();
                alert = wait.until(ExpectedConditions.alertIsPresent());
                System.out.println(alert.getText());
                alert.sendKeys("abc");
                alert.accept();
                System.out.println("Result: " + driver.findElement(resultSel).getText());


            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                driver.quit();
            }
    }
}
