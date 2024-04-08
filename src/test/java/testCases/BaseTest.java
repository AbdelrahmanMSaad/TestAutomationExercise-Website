package testCases;

import base.Navigation;
import org.testng.annotations.*;
import pages.pages.HomePage;

public class BaseTest {
    protected static HomePage homePage;

    @BeforeSuite
    public void beforeSuite(){
    }

    @BeforeTest
    public void beforeTest(){
    }

    @BeforeGroups
    public void beforeGroups(){
    }

    @BeforeClass
    public void beforeClass() {
    }



    @AfterClass
    public void afterClass(){
    }

    @AfterGroups
    public void afterGroups(){
    }

    @AfterTest
    public void afterTest(){
    }

    @AfterSuite
    public void afterSuite(){
    }
}
