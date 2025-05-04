package com.kuldeepkumar290497.pages.pageFactory.appvwo;

import com.kuldeepkumar290497.base.CommonToAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static com.kuldeepkumar290497.utils.WaitHelper.visibilityOfElement;

public class DashBoard_PF extends CommonToAll {
    WebDriver driver;
    public DashBoard_PF(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(css = "[data-qa='lufexuloga']")
    private WebElement userNameOnDashBoard;


    public String LoggedInUser(){
        visibilityOfElement(userNameOnDashBoard);
        return getText(userNameOnDashBoard);

    }
}
