package models.components;

import org.openqa.selenium.WebDriver;

public class InternalLoginPage extends LoginPage {

    public InternalLoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void inputUsername(String username) {
        System.out.println("input internal username");
    }

    @Override
    protected void inputPassword(String password) {
        System.out.println("input internal password");
    }

    @Override
    protected void clickOnLoginBtn() {
        System.out.println("click login btn");
    }
}
