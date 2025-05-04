package com.kuldeepkumar290497.tests.pom.vwo;

import com.kuldeepkumar290497.driver.DriverManagerTL;
import com.kuldeepkumar290497.pages.pageObjectModel.appVwo.improvedPOM.DashboardPage;
import com.kuldeepkumar290497.pages.pageObjectModel.appVwo.improvedPOM.LoginPageIM;
import com.kuldeepkumar290497.utils.PropertiesReader;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestVWOLoginImprovedCommonToAll {

    LoginPageIM loginPage;
    @Description("Verify that with invalid email, pass, error message is shown on the app.vwo.com")
    @Test
    public void LoginVWO_NegativeTest() {
        
        String errorMsg = loginPage.loginToVWOLoginInvalidCreds(PropertiesReader.readKey("invalid_username"), PropertiesReader.readKey("invalid_password"));

// Assertions
        assertThat(errorMsg).isNotBlank().isNotNull().isNotEmpty();
        Assert.assertEquals(errorMsg,PropertiesReader.readKey("error_message"));


    }

    @Owner("Kuldeep Kumar")
    @Description("Verify that valid credentials dashboard page is loaded")
    @Test
    public void LoginVWO_PositiveTest(){
        
        loginPage.loginToVWOLoginValidCreds(PropertiesReader.readKey("username"),PropertiesReader.readKey("password"));

        DashboardPage dashBoardPage = new DashboardPage(DriverManagerTL.getDriver());
        String userName = dashBoardPage.loggedInUsername();

        assertThat(userName).isNotEmpty().isNotNull().isNotBlank();
        Assert.assertEquals(userName,PropertiesReader.readKey("expected_username"));
        
    }
    @BeforeMethod
    void setup(){
        DriverManagerTL.init();

        //Page Class Code
       loginPage = new LoginPageIM(DriverManagerTL.getDriver());
        
    }
    
    @AfterMethod
    void tearDown(){

        DriverManagerTL.getDriver().quit();
    }
    
    
}
