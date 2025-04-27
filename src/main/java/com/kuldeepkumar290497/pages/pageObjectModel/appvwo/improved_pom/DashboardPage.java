package com.kuldeepkumar290497.pages.pageObjectModel.appvwo.improved_pom;

import com.kuldeepkumar290497.base.CommonToAll;
import com.kuldeepkumar290497.utils.waitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage extends CommonToAll {
    WebDriver driver;
    public DashboardPage(WebDriver driver){
        this.driver = driver;
    }

    private By userNameOnDashboard = By.cssSelector("[data-qa=\"lufexuloga\"]");

    public String loggedInUsername(){
        waitHelpers.visibilityOfElement(userNameOnDashboard);
        return getText(userNameOnDashboard);

    }
}
