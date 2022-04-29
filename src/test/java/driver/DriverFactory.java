package driver;

import org.apache.commons.exec.OS;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class DriverFactory {

    public static WebDriver getChromeDriver(){
        String currentProjectPath = System.getProperty("user.dir");
        String macOSChromePath = "/src/test/resources/drivers/chromedriver";
        String windowsChromePath = "\\src\\test\\resources\\drivers\\chromedriver.exe";
        String relativeChromeDriverPath = OS.isFamilyMac()? macOSChromePath : windowsChromePath;
        String chromeDriverPath = currentProjectPath.concat(relativeChromeDriverPath);
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito");

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5l));
        return driver;
    }
}
