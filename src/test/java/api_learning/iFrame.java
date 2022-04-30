package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static api_learning.Urls.baseUrl;
import static api_learning.Urls.iFramePage;
;

public class iFrame {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();
        try {
            driver.get(baseUrl.concat(iFramePage));
            //css selector : []
            //<html> inside <html>
            //$('[id$="ifr"]')- console ->$ end by ifr
            //$('[id^="abd"]') - console -> ^ start by abd

            By iFrameSel = By.cssSelector("[id$='ifr']");
            WebElement iFrameElem = driver.findElement(iFrameSel);

            driver.switchTo().frame(iFrameElem);

            WebElement editorInputElem = driver.findElement(By.id("tinymce"));
            editorInputElem.click();
            editorInputElem.clear();
            editorInputElem.sendKeys("this is few text....");

            driver.switchTo().defaultContent();

            System.out.println(driver.findElement(By.linkText("Elemental Selenium")).getAttribute(("href")));



        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
