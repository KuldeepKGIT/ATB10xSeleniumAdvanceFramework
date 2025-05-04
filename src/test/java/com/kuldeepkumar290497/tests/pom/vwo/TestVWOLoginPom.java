package com.kuldeepkumar290497.tests.pom.vwo;

import com.kuldeepkumar290497.pages.pageObjectModel.appVwo.normal_pom.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestVWOLoginPom {
    @Test
    public void testLoginNegativeVWO(){
        WebDriver driver = new EdgeDriver();
        LoginPage loginPagePom = new LoginPage(driver);
        String error_msg_text = loginPagePom.loginAppVWO_invalidCred("admin@gmail.com", "admin");
        Assert.assertEquals(error_msg_text,"Your email, password, IP address or location did not match");
        driver.quit();
    }

    @Test
    public void testLoginNegativeVWO2(){
        WebDriver driver = new EdgeDriver();
        LoginPage loginPagePom = new LoginPage(driver);
        String error_msg_text = loginPagePom.loginAppVWO_invalidCred("pramod@gmail.com", "admin");
        Assert.assertEquals(error_msg_text,"Your email, password, IP address or location did not match");
        driver.quit();
    }
}
