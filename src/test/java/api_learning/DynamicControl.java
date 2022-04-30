package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DynamicControl {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();

        try{
            driver.get("https://the-internet.herokuapp.com/dynamic_controls");
            By checkboxFormSel = By.id("checkbox-example");
            By inputFormSel = By.id("input-example");

            WebElement checkboxFormElem = driver.findElement(checkboxFormSel);
            WebElement checkboxElem = checkboxFormElem.findElement(By.tagName("input"));

            if(!checkboxElem.isSelected()){
                checkboxElem.click();
            }

            WebElement inputFormElem = driver.findElement(inputFormSel);
            By inputElemSel = By.tagName("input");
            WebElement inputElem = inputFormElem.findElement(inputElemSel);
            WebElement inputBtnElem = inputFormElem.findElement(By.tagName("button"));

            if(!inputElem.isEnabled()){
                inputBtnElem.click();
            }

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20l));
            wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.id("loading"))));
            inputElem.sendKeys("testingggggggggggggg");


        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            driver.quit();
        }
    }
}
