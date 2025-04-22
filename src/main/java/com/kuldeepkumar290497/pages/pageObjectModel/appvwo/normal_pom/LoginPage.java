package com.kuldeepkumar290497.pages.pageObjectModel.appvwo;

import com.kuldeepkumar290497.utils.waitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.kuldeepkumar290497.utils.waitHelpers.waitJVM;

//page class
public class LoginPage {
   WebDriver driver;

   public  LoginPage (WebDriver driver){
            this.driver = driver;
   }

   //Step 1 - page locators

    private By username = By.id("login-username");
    private By password = By.id("login-password");
    private By signButton = By.id("js-login-btn");
    private By error_message = By.id("js-notification-box-msg");

    // Step-2 Page Actions
    public String loginAppVWO_invalidCred (String user, String pwd){
        driver.get("https://app.vwo.com");
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(signButton).click();

        waitHelpers.checkVisibility(driver,error_message);

        String Error_message_txt = driver.findElement(error_message).getText();
        return Error_message_txt;

    }
    public void loginAppVWO_validCred(String user, String pwd) {


        driver.get("https://app.vwo.com");
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(signButton).click();

        // Wait - Thread sleep
        waitJVM(5000);
    }

}
