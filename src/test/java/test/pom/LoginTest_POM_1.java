package test.pom;

import driver.DriverFactory;
import models.pages.LoginPage;
import org.openqa.selenium.WebDriver;

import static api_learning.Urls.baseUrl;
import static api_learning.Urls.loginSlug;

public class LoginTest_POM_1 {

    public static void main(String[] args) {

        WebDriver driver = DriverFactory.getChromeDriver();

        try {
            driver.get(baseUrl.concat(loginSlug));

            LoginPage loginPage = new LoginPage(driver);
            loginPage.usernameElem().sendKeys("Teo@sth.com");
            loginPage.passwordElem().sendKeys("12345678");
            loginPage.loginBtnElem().click();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            driver.quit();
        }
    }
}
