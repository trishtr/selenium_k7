package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static api_learning.Urls.baseUrl;
import static api_learning.Urls.dropdownOptionPage;

public class Dropdown {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();
        try{
            driver.get(baseUrl.concat(dropdownOptionPage));

            By dropdownSel = By.id("dropdown");
            WebElement dropdownElem = driver.findElement(dropdownSel);

            Select select = new Select(dropdownElem);

            select.selectByVisibleText("Option 1");
            select.selectByIndex(2);
            select.selectByValue("1");

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally {
            driver.quit();
        }
    }
}
