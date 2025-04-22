package com.kuldeepkumar290497.pages.pageObjectModel.appvwo.improved_pom;

import com.kuldeepkumar290497.base.CommonToAll;
import com.kuldeepkumar290497.utils.waitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.kuldeepkumar290497.driver.DriverManager.getDriver;

public class LoginPage extends CommonToAll {

    //Page class
//    WebDriver driver;
//
//        public LoginPage(WebDriver driver){
//            this.driver = driver;
//        }
//Page Locators

    private By username = By.id("login-username");
    private By password = By.id("login-password");
    private By signButton = By.id("js-login-btn");
    private By error_message = By.id("js-notification-box-msg");

    public String loginToVWOLoginInvalidCreds(String user, String pwd){
        openVWOUrl();
        enterInput(username,user);
        enterInput(password,pwd);
        clickElement(signButton);
        waitHelpers.checkVisibility(getDriver(),error_message);
        return getText(error_message);
    }
    public void loginToVWOLoginValidCreds(String user, String pwd) {
        openVWOUrl();
        enterInput(username,user);
        enterInput(password,pwd);
        clickElement(signButton);

    }





}
