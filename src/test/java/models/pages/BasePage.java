package models.pages;

import models.components.Component;
import models.components.HeaderComponent;
import models.global.footer.FooterComponent;
import models.global.TopMenuComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage extends Component {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        super(driver, driver.findElement(By.tagName("html")));
        this.driver = driver;
    }

    public FooterComponent footerComp(){
        return findComponent(FooterComponent.class, driver);
    }

    public TopMenuComponent topMenuComponent() {
        return findComponent(TopMenuComponent.class, driver);
    }
}
