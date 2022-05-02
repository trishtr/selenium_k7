package models.pages;

import models.components.LoginComponent;
import org.openqa.selenium.WebDriver;


public class LoginPage_ComponentEx extends BasePage{

   public LoginPage_ComponentEx(WebDriver driver){
       super(driver);
   }

    public LoginComponent loginComponent(){
        return findComponent(LoginComponent.class, driver);
    }


}
