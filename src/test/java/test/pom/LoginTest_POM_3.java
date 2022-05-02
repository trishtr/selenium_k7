package test.pom;

import driver.DriverFactory;
import models.pages.LoginPage;
import org.openqa.selenium.WebDriver;

import static api_learning.Urls.baseUrl;
import static api_learning.Urls.loginSlug;

public class LoginTest_POM_3 {

    public static void main(String[] args) {

        WebDriver driver = DriverFactory.getChromeDriver();

        try {
            driver.get(baseUrl.concat(loginSlug));

            LoginPage loginPage = new LoginPage(driver);
                loginPage._inputUsername("Teo@sth.com")
                         ._inputPassword("12345678")
                         .clickLoginBtn();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
