package test.pom;

import driver.DriverFactory;
import models.pages.LoginPage;
import org.openqa.selenium.WebDriver;

import static api_learning.Urls.baseUrl;
import static api_learning.Urls.loginSlug;

public class LoginTest_POM_2 {

    public static void main(String[] args) {

        WebDriver driver = DriverFactory.getChromeDriver();

        try {
            driver.get(baseUrl.concat(loginSlug));

            LoginPage loginPage = new LoginPage(driver);
            loginPage.inputUsername("Teo@sth.com");
            loginPage.inputPassword("12345678");
            loginPage.clickLoginBtn();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
