package com.kuldeepkumar290497.tests.pom.vwo.ddt_vwo;

import com.kuldeepkumar290497.base.CommonToAllTestTL;
import com.kuldeepkumar290497.pages.pageObjectModel.appVwo.improvedPOM.LoginPageIM;
import com.kuldeepkumar290497.utils.PropertiesReader;
import com.kuldeepkumar290497.utilsExcel.UtilExcel;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.kuldeepkumar290497.driver.DriverManagerTL.getDriver;

public class TestVWO_DDT extends CommonToAllTestTL {

    @Test(dataProvider = "dp")
    public void TestVWO_negative(String email, String password){
        System.out.println(email + " - "+ password);
        LoginPageIM loginPageIM = new LoginPageIM(getDriver());
        String error_msg = loginPageIM.loginToVWOLoginInvalidCreds(email, password);
        Assert.assertEquals(getDriver().getTitle(), PropertiesReader.readKey("current_title"));
        Assert.assertEquals(getDriver().getCurrentUrl(), PropertiesReader.readKey("current_url"));

        Assert.assertEquals(error_msg,PropertiesReader.readKey("error_message"));
    }
    @DataProvider(name = "dp", parallel = true)
    public Object[][] getData(){
        // READ THE DATA FROM THE EXCEL FILE
        // GIVE THEM IN THE 2D ARRAY
        return UtilExcel.getTestDataFromExcel("sheet1");
    }


}
