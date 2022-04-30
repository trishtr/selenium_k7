package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import static api_learning.Urls.baseUrl;
import static api_learning.Urls.floatingPageSlug;

public class JSSnippetExecution {

    public static void main(String[] args) {

        WebDriver driver = DriverFactory.getChromeDriver();
        driver.get(baseUrl.concat(floatingPageSlug));

        try {
            //floating elements
           scrollToBottom(driver);

           scrollToTop(driver);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }

    }
    private static void scrollToBottom(WebDriver driver){
        //interface : javascriptexecutor
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("window.scrollTo(0,document.body.scrollHeight);");


    }
    private static void scrollToTop(WebDriver driver){
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("window.scrollTo(document.body.scrollHeight,0);");

    }

}