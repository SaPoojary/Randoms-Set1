package com.blaze.qa.test;

import com.blaze.qa.base.BaseTest;
import com.blaze.qa.pages.ConfirmationPage;
import com.blaze.qa.pages.PurchasePage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PurchasePageTest extends BaseTest {

    PurchasePage purchasePage;
    ConfirmationPage confirmationPage;

    public PurchasePageTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialize();
        purchasePage = new PurchasePage();
        driver.get(config_prop.getProperty("purchasePageUrl"));
    }

    @Test(priority=1)
    public void purchaseTicket() {
        confirmationPage = purchasePage.fillUserDetails();
        String confirmationMsg = confirmationPage.getPageHeader();
        Assert.assertEquals(confirmationMsg, "Thank you for your purchase today!");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
    }