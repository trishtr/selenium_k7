package models.components;

import org.openqa.selenium.WebDriver;

public abstract class LoginPage {
    //IS
    protected final WebDriver driver;

    protected LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    protected abstract void inputUsername(String username);
    protected abstract void inputPassword(String password);
    protected abstract void clickOnLoginBtn();
}
