package test.testng;

import org.testng.annotations.*;

public class FooterTest {

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("b4 suite");
    }
    @BeforeTest //(check - test tag in xml-tests group)
    public void beforeTest(){
        System.out.println("b4 test");
    }

    @BeforeClass //
    public void beforeClass(){
        System.out.println("b4 class");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("b4 method");
    }

    @Ignore
    @Test
    public void testFooterHomePage(){
        System.out.println("Footer Test");
    }

    @Test
    public void testFooterCategoryPage(){
        System.out.println("Category Test");
    }

    @BeforeSuite
    public void afterSuite(){
        System.out.println("after suite");
    }
    @BeforeTest //(check - test tag in xml-tests group)
    public void afterTest(){
        System.out.println("after test");
    }

    @BeforeClass //
    public void afterClass(){
        System.out.println("after class");
    }

    @BeforeMethod
    public void afterMethod(){
        System.out.println("after method");
    }
}
