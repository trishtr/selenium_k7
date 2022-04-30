package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

import static api_learning.Urls.*;

public class MouseHover {

    private static final By figureSel = By.className("figure");
    private static final By profileNameSel = By.cssSelector(".figcaption h5");
    private static final By profileLinkSel = By.cssSelector(".figcaption a");

    public static void main(String[] args) {

    WebDriver driver = DriverFactory.getChromeDriver();
    try {
            driver.get(baseUrl.concat(hovers));
            List<WebElement> figureElems = driver.findElements(figureSel);
            if(figureElems.isEmpty())
            {
                throw new RuntimeException("Thre is no profile image");
            }

            Actions actions = new Actions(driver);

        /**************find child elementS by parent element
        //IMPORTANT
        //IMPORTANT
         narrowing down searching scope
         ****************************/

        for (WebElement figureElem: figureElems) {
            WebElement profileNameElem = figureElem.findElement(profileNameSel);
            WebElement profileLinkElem = figureElem.findElement(profileLinkSel);

            System.out.println("Is profileName displaying: " + profileNameElem.isDisplayed());
            System.out.println("Is profileLink displaying: " + profileLinkElem.isDisplayed());

           actions.moveToElement(figureElem).perform();

            System.out.println("Is profileName displaying: " + profileNameElem.isDisplayed());
            System.out.println("Is profileLink displaying: " + profileLinkElem.isDisplayed());

            System.out.println(profileNameElem.getText());
            System.out.println(profileLinkElem.getAttribute("href"));


        }
        }
    catch(Exception e) {
            e.printStackTrace();
        }
    finally {
            driver.quit();
        }
}
}