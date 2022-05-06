package models.global.footer;

import models.components.Component;
import models.components.ComponentCssSelector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.xml.stream.XMLStreamReader;

@ComponentCssSelector(".column.information")
public class InformationColumnComponent extends FooterColumnComponent {


    public InformationColumnComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }



}
