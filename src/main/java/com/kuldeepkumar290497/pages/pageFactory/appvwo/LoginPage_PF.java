package com.kuldeepkumar290497.pages.pageFactory.appvwo;

import com.kuldeepkumar290497.base.CommonToAll;
import com.kuldeepkumar290497.utils.PropertiesReader;
import com.kuldeepkumar290497.utils.waitHelpers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage_PF extends CommonToAll {
    WebDriver driver;
    public LoginPage_PF(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);

    }
    @FindBy(id="login-username")
    private WebElement username;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(id = "js-login-btn")
    private WebElement signButton;

    @FindBy(css = "#js-notification-box-msg")
    private WebElement error_message;

    // Page Actions
    public String loginToVWOInvalidCreds() {
        openVWOUrl();
        enterInput(username, PropertiesReader.readKey("invalid_username"));
        enterInput(password, PropertiesReader.readKey("invalid_password"));
        clickElement(signButton);
        waitHelpers.waitJVM(5000);
        return getText(error_message);

    }
}
