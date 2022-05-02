package models.components;

import org.openqa.selenium.WebDriver;

public class ExternalLoginPage extends LoginPage {

    public ExternalLoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void inputUsername(String username) {
        System.out.println("external username");
    }

    @Override
    protected void inputPassword(String password) {
        System.out.println("external password");
    }

    @Override
    protected void clickOnLoginBtn() {
        System.out.println("external click");
    }
}
