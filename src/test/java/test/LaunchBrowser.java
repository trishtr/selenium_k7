package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LaunchBrowser {

    public static void main(String[] args) throws InterruptedException {


        String currentProjectPath = System.getProperty("user.dir");
        String chromeDriverPath = currentProjectPath + "/src/test/resources/drivers/chromedriver";
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito");

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://sdetpro.com");

        Thread.sleep(3000);

        driver.quit();
    }
}
