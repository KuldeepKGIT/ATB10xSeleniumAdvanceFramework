package com.kuldeepkumar290497.tests.pom.vwo;

import com.kuldeepkumar290497.base.CommonToAllTest;
import com.kuldeepkumar290497.listners.RetryAnalyzer;
import com.kuldeepkumar290497.listners.ScreenshotListener;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.kuldeepkumar290497.driver.DriverManager.getDriver;

@Listeners(ScreenshotListener.class)
@Test(retryAnalyzer = RetryAnalyzer.class)
public class TestVWO_retry extends CommonToAllTest {
    private static final Logger logger = LogManager.getLogger(TestVWO_retry.class);

    @Owner("PRAMOD")
    @Description("Verify that invalid creds give error message")
    @Test
    public void testFail() {
        getDriver().get("https://app.vwo.com");
        logger.info("Starting the 1 Testcase Page Object Model");
        Assert.assertTrue(false);
    }

    @Owner("PRAMOD")
    @Description("Verify that invalid creds give error message")
    @Test
    public void testPass() {
        getDriver().get("https://app.vwo.com");
        logger.info("Starting the 2 Testcase Page Object Model");
        Assert.assertTrue(true);
    }

}
