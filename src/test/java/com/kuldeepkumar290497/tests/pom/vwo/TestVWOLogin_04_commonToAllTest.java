package com.kuldeepkumar290497.tests.pom.vwo;

import com.kuldeepkumar290497.base.CommonToAllTest;
import com.kuldeepkumar290497.driver.DriverManager;
import com.kuldeepkumar290497.pages.pageObjectModel.appVwo.improvedPOM.DashboardPage;
import com.kuldeepkumar290497.pages.pageObjectModel.appVwo.improvedPOM.LoginPageIM;
import com.kuldeepkumar290497.utils.PropertiesReader;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestVWOLogin_04_commonToAllTest extends CommonToAllTest {
    @Description("Verify that with invalid email, pass, error message is shown on the app.vwo.com")
    @Test
    public void LoginVWO_NegativeTest() throws Exception {

        //Page Class Code
        LoginPageIM loginPage = new LoginPageIM(DriverManager.getDriver());
        String error_msg = loginPage.loginToVWOLoginInvalidCreds(PropertiesReader.readKey("invalid_username"), PropertiesReader.readKey("invalid_password"));

// Assertions
        assertThat(error_msg).isNotBlank().isNotNull().isNotEmpty();
        Assert.assertEquals(error_msg, PropertiesReader.readKey("error_message"));
    }

        @Owner("Kuldeep Kumar")
        @Description("Verify that valid creds dashboard page is loaded")
        @Test
        public void LoginVWO_PositiveTest () {


            LoginPageIM loginPage_vwo = new LoginPageIM(DriverManager.getDriver());
            loginPage_vwo.loginToVWOLoginValidCreds(PropertiesReader.readKey("username"), PropertiesReader.readKey("password"));

            DashboardPage dashBoardPage = new DashboardPage(DriverManager.getDriver());
            String UserNameLoggedIn = dashBoardPage.loggedInUsername();

            assertThat(UserNameLoggedIn).isNotEmpty().isNotNull().isNotBlank();
            Assert.assertEquals(UserNameLoggedIn, PropertiesReader.readKey("expected_username"));

        }
    }
