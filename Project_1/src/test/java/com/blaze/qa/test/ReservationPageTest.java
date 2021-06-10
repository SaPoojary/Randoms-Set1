package com.blaze.qa.test;

import com.blaze.qa.base.BaseTest;
import com.blaze.qa.pages.HomePage;
import com.blaze.qa.pages.PurchasePage;
import com.blaze.qa.pages.ReservationPage;
import com.blaze.qa.utils.TestUtils;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ReservationPageTest extends BaseTest {

    PurchasePage purchasePage;
    ReservationPage reservationPage;

    public ReservationPageTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialize();
        reservationPage = new ReservationPage();
        driver.get(config_prop.getProperty("reservationPageUrl"));
    }



    @Test(priority=1)
    public void selectFlight(){
        purchasePage = reservationPage.selectFlight();
        String reservationPageTitle = purchasePage.getPageHeader();
        Assert.assertTrue(reservationPageTitle.contains("has been reserved"));
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}