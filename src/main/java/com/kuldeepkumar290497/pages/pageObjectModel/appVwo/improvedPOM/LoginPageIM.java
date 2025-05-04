package com.kuldeepkumar290497.pages.pageObjectModel.appVwo.improvedPOM;

import com.kuldeepkumar290497.base.CommonToAll;
import com.kuldeepkumar290497.utils.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.kuldeepkumar290497.driver.DriverManager.getDriver;

public class LoginPageIM extends CommonToAll {

    //Page class
    WebDriver driver;



        public LoginPageIM(WebDriver driver){
            this.driver = driver;
        }
//Page Locators

    private final By username = By.id("login-username");
    private final By password = By.id("login-password");
    private final By signButton = By.id("js-login-btn");
    private final By errorMessage = By.id("js-notification-box-msg");

    public String loginToVWOLoginInvalidCreds(String user, String pwd){
        openVWOUrl();
        enterInput(username,user);
        enterInput(password,pwd);
        clickElement(signButton);
        WaitHelper.checkVisibility(getDriver(), errorMessage);
        return getText(errorMessage);
    }
    public void loginToVWOLoginValidCreds(String user, String pwd) {
        openVWOUrl();
        enterInput(username,user);
        enterInput(password,pwd);
        clickElement(signButton);

    }





}
