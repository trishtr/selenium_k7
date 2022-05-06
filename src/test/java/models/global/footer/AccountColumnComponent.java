package models.global.footer;

import models.components.ComponentCssSelector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@ComponentCssSelector(".column.my-account")
public class AccountColumnComponent extends FooterColumnComponent{

    public AccountColumnComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }
}
