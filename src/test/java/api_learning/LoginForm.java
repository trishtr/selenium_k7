package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginForm {

    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();

        try {
            driver.get("https://the-internet.herokuapp.com/login");
            By usernameSel = By.id("username");
            By passwordSel = By.cssSelector("#password");
            By loginBtnSel = By.cssSelector("[type='submit']");

            WebElement usernameElem = driver.findElement(usernameSel);
            WebElement passwordElem = driver.findElement(passwordSel);
            WebElement loginBtnElem = driver.findElement(loginBtnSel);

            usernameElem.sendKeys("tomsmith");
            passwordElem.sendKeys("SuperSecretPassword!");
            loginBtnElem.click();

           printTitleURL(driver);

            By welcomeTextSel = By.cssSelector("h4");
            WebElement welcomeTextElem = driver.findElement(welcomeTextSel);
            System.out.println(welcomeTextElem.getText());

            driver.navigate().back();
            printTitleURL(driver);

            //check no element -list = empty/ locator= right /
            List<WebElement> loginInputFieldElems = driver.findElements(By.tagName("input"));
            if(loginInputFieldElems.isEmpty())
                throw new RuntimeException("There is no login form input fields");

            final int USERNAME_INDEX =0;
            final int PASSWORD_INDEX =0;
            usernameElem= loginInputFieldElems.get(USERNAME_INDEX);
            usernameElem.clear();
            usernameElem.sendKeys("teo");
            loginInputFieldElems.get(PASSWORD_INDEX).sendKeys("password");

            loginBtnElem = driver.findElement(loginBtnSel);
            loginBtnElem.click();

            //By.partialLinkText()
            By poweredByLinkSel = By.linkText("Elemental Selenium");
            WebElement poweredByLinkELem = driver.findElement(poweredByLinkSel);
            System.out.println("poweredByLink Text:" + poweredByLinkELem.getText());

            By loginMsgSel = By.cssSelector(".error");
            WebElement loginMsgElem = driver.findElement(loginMsgSel);
            //.getCssValue()
            String loginMsgBackgroundColor = loginMsgElem.getCssValue("background-color");
            System.out.println("loginMsg background color : " + loginMsgBackgroundColor);

            System.out.println(loginMsgElem.getAttribute("class"));



        }

        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            driver.quit();
        }
    }

    private static void printTitleURL(WebDriver driver)
    {
        System.out.println("\t --> " + driver.getTitle());
        System.out.println("\t --> " + driver.getCurrentUrl());
    }

    //narrowing down searching scope
    //element.element

}
