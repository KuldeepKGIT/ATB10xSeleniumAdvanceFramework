package com.kuldeepkumar290497.pages.pageObjectModel.appvwo.normal_pom;

import com.kuldeepkumar290497.utils.waitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashBoardPage {
    WebDriver driver;
    public DashBoardPage(WebDriver driver){
        this.driver = driver;
    }

    private By userNameOnDashboard = By.cssSelector("[data-qa=\"lufexuloga\"]");

    public String loggedInUsername(){
        waitHelpers.checkVisibility(driver,userNameOnDashboard);
        return driver.findElement(userNameOnDashboard).getText();
    }
}
