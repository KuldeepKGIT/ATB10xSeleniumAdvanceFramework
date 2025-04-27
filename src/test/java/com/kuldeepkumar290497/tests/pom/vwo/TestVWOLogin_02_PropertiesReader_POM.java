package com.kuldeepkumar290497.tests.pom.vwo;

import com.kuldeepkumar290497.driver.DriverManager;
import com.kuldeepkumar290497.pages.pageObjectModel.appvwo.normal_pom.DashBoardPage;
import com.kuldeepkumar290497.pages.pageObjectModel.appvwo.normal_pom.LoginPage;
import com.kuldeepkumar290497.utils.PropertiesReader;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestVWOLogin_02_PropertiesReader_POM {
    @Description("Verify that with invalid email, pass, error message is shown on the app.vwo.com")
    @Test
    public void LoginVWO_NegativeTest() throws Exception{
        DriverManager.init();

        //Page Class Code
        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        String error_msg = loginPage.loginAppVWO_invalidCred(PropertiesReader.readKey("invalid_username"), PropertiesReader.readKey("invalid_password"));

// Assertions
        assertThat(error_msg).isNotBlank().isNotNull().isNotEmpty();
        Assert.assertEquals(error_msg,PropertiesReader.readKey("error_message"));

        DriverManager.getDriver().quit();

    }

    @Owner("Kuldeep Kumar")
    @Description("Verify that valid creds dashboard page is loaded")
    @Test
    public void LoginVWO_PositiveTest(){
            DriverManager.init();
        LoginPage loginPage_vwo = new LoginPage(DriverManager.getDriver());
        loginPage_vwo.loginAppVWO_validCred(PropertiesReader.readKey("username"),PropertiesReader.readKey("password"));

        DashBoardPage dashBoardPage = new DashBoardPage(DriverManager.getDriver());
        String UserNameLoggedIn = dashBoardPage.loggedInUsername();

        assertThat(UserNameLoggedIn).isNotEmpty().isNotNull().isNotBlank();
        Assert.assertEquals(UserNameLoggedIn,PropertiesReader.readKey("expected_username"));
        DriverManager.getDriver().quit();
    }
}
