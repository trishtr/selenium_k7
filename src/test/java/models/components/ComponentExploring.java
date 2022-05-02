package models.components;

import driver.DriverFactory;
import org.openqa.selenium.WebDriver;

import java.lang.reflect.Constructor;

public class ComponentExploring {
    //Java reflections
    //Generic type, boundary <T extends LoginPage>
    //type T extends : boundary
    public<T extends LoginPage>void login(Class<T> loginPageClass){
        //define parameters which can be used in the constructor
        Class<?>[] parameters = new Class[]{WebDriver.class};

        try
        {
            /****** ******/
            Constructor<T> constructor = loginPageClass.getConstructor(parameters);
            T loginPageObject = constructor.newInstance(DriverFactory.getChromeDriver());


            loginPageObject.inputUsername("username");
            loginPageObject.inputPassword("password");
            loginPageObject.clickOnLoginBtn();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new ComponentExploring().login(InternalLoginPage.class);
        System.out.println();
        new ComponentExploring().login(ExternalLoginPage.class);
    }
}
