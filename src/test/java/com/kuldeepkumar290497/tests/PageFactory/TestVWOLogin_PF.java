package com.kuldeepkumar290497.tests.PageFactory;

import com.kuldeepkumar290497.base.CommonToAllTest;
import com.kuldeepkumar290497.pages.pageFactory.appvwo.LoginPage_PF;
import com.kuldeepkumar290497.utils.PropertiesReader;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.kuldeepkumar290497.driver.DriverManager.getDriver;

public class TestVWOLogin_PF extends CommonToAllTest {
    @Test
    public void TestLogin_NegativeTest(){
        LoginPage_PF loginPagePf = new LoginPage_PF(getDriver());
       String error_msg= loginPagePf.loginToVWOInvalidCreds();
        Assert.assertEquals(error_msg, PropertiesReader.readKey("error_message"));
    }
}
