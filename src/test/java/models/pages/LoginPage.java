package models.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private final WebDriver driver;
    private final static By usernameSel = By.id("username");
    private final static By  passwordSel = By.id("password");
    private final static By loginBtnSel = By.cssSelector("[type='submit']");


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement usernameElem(){
        return driver.findElement(usernameSel);
    }

    public WebElement passwordElem(){
        return driver.findElement(passwordSel);
    }

    public WebElement loginBtnElem(){
        return driver.findElement(loginBtnSel);
    }

    public void inputUsername(String username){
        if(username.isEmpty())
            return;
        driver.findElement(usernameSel).sendKeys(username);
    }

    public LoginPage _inputUsername(String username){
        if(username.isEmpty())
            return this;
        driver.findElement(usernameSel).sendKeys(username);
        return this;
    }
    public void inputPassword(String password){
        if(password.isEmpty())
            return;
        driver.findElement(passwordSel).sendKeys(password);
    }

    public LoginPage _inputPassword(String password){
        if(password.isEmpty())
            return this;
        driver.findElement(passwordSel).sendKeys(password);
        return this;
    }
    public void clickLoginBtn(){
        driver.findElement(loginBtnSel).click();
    }

}
