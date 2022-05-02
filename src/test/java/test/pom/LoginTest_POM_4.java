package test.pom;

import driver.DriverFactory;
import models.components.LoginComponent;
import models.pages.LoginPage;
import models.pages.LoginPage_ComponentEx;
import org.openqa.selenium.WebDriver;

import static api_learning.Urls.baseUrl;
import static api_learning.Urls.loginSlug;

public class LoginTest_POM_4 {

    public static void main(String[] args) {

        WebDriver driver = DriverFactory.getChromeDriver();

        try {
            driver.get(baseUrl.concat(loginSlug));

            LoginPage_ComponentEx loginPage_componentEx = new LoginPage_ComponentEx(driver);
            LoginComponent loginComponent = loginPage_componentEx.loginComponent();
            loginComponent.inputUsername("abcs");

            Thread.sleep(3000);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}