package test.global;

import driver.DriverFactory;
import models.global.TopMenuComponent;
import models.global.footer.FooterColumnComponent;
import models.global.footer.FooterComponent;
import models.global.footer.InformationColumnComponent;
import models.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.security.SecureRandom;
import java.time.Duration;
import java.util.List;

public class FooterTest {

    @Test
    public void testFooterHomePage(){
            WebDriver driver = DriverFactory.getChromeDriver();
            try {
                driver.get("http://demowebshop.tricentis.com/");
                HomePage homePage = new HomePage(driver);
                FooterComponent footerComponent = homePage.footerComp();

                InformationColumnComponent informationColumnComponent = footerComponent.informationColumnComp();
                System.out.println(informationColumnComponent.headerElem().getText());

                if(informationColumnComponent.linkElems().isEmpty()){
                    throw new RuntimeException("[ERR] There is no links in the column component");
                }
                informationColumnComponent.linkElems().forEach(link ->{
                    System.out.println("\t  " + link.getText());
                    System.out.println(link.getAttribute("href"));
                });

                System.out.println(footerComponent.customerServiceColumnComponent().headerElem().getText());
                System.out.println(footerComponent.accountColumnComponent().headerElem().getText());
                System.out.println(footerComponent.followUsColumnComponent().headerElem().getText());
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            finally{
                driver.quit();
            }
    }

    @Test
    public void testFooterCategoryPage(){
        WebDriver driver = DriverFactory.getChromeDriver();
        try {
            driver.get("http://demowebshop.tricentis.com/");
            HomePage homePage = new HomePage(driver);
            TopMenuComponent topMenuComponent = homePage.topMenuComponent();

            List<WebElement> mainItemElems = topMenuComponent.mainItemElems();

            WebElement randomMainItemElem =  mainItemElems.get(new SecureRandom().nextInt(mainItemElems.size()));
            randomMainItemElem.click();

            Thread.sleep(2000);
           // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            // wait.until(ExpectedConditions.urlContains(randomMainItemElem.getText()));

            FooterComponent footerComponent = homePage.footerComp();
            InformationColumnComponent informationColumnComponent = footerComponent.informationColumnComp();
            System.out.println(informationColumnComponent.headerElem().getText());
            if(informationColumnComponent.linkElems().isEmpty()){
                throw new RuntimeException("[ERR] There is no links in the column component");
            }
            informationColumnComponent.linkElems().forEach(link ->{
                System.out.println("\t  " + link.getText());
                System.out.println(link.getAttribute("href"));
            });


        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally{
            driver.quit();
        }
    }
}
