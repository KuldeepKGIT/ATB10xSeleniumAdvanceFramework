package com.kuldeepkumar290497.tests.pom.vwo;

import com.kuldeepkumar290497.pages.pageObjectModel.appVwo.normal_pom.DashBoardPage;
import com.kuldeepkumar290497.pages.pageObjectModel.appVwo.normal_pom.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestVWOLogin_01_NormalScript_POM {

    @Description("Verify that with invalid email, pass, error message is shown on the app.vwo.com")
    @Test
    public void LoginVWO_NegativeTest(){

        //Driver manager Code
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");
        WebDriver driver = new EdgeDriver(edgeOptions);

        //Page Class Code
        LoginPage loginPage = new LoginPage(driver);
        String error_msg = loginPage.loginAppVWO_invalidCred("admin@gmail.com","1234");

        // Assertions - 3
        assertThat(error_msg).isNotBlank().isNotNull().isNotEmpty();
        Assert.assertEquals(error_msg,"Your email, password, IP address or location did not match");

        driver.quit();



    }
    @Owner("Kuldeep Kumar")
    @Description("Verify that valid creds dashboard page is loaded")
    @Test
    public void LoginVWO_PositiveTest(){
        WebDriver driver = new EdgeDriver();

        LoginPage loginPage_vwo = new LoginPage(driver);
        loginPage_vwo.loginAppVWO_validCred("contact+aug@thetestingacademy.com","TtxkgQ!s$rJBk85");

        DashBoardPage dashBoardPage = new DashBoardPage(driver);
        String UserNameLoggedIn = dashBoardPage.loggedInUsername();

        assertThat(UserNameLoggedIn).isNotEmpty().isNotNull().isNotBlank();
        Assert.assertEquals(UserNameLoggedIn,"Aman");
        driver.quit();
    }
}
