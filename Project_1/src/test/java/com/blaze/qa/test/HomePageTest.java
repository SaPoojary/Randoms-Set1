package com.blaze.qa.test;

import com.blaze.qa.base.BaseTest;
import com.blaze.qa.pages.HomePage;
import com.blaze.qa.pages.ReservationPage;
import com.blaze.qa.utils.TestUtils;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

    HomePage homePage;
    ReservationPage reservationPage;
    public String sheetName = "HomePage";

    public HomePageTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialize();
        homePage = new HomePage();
    }


    @DataProvider
    public Object[][] getTestData(){
        Object data[][] = TestUtils.getTestData(sheetName);
        return data;
    }

    @Test(priority=1, dataProvider = "getTestData")
    public void findFlights(String fromCity, String toCity){
        reservationPage = homePage.book_flight(fromCity, toCity);
        String reservationPageTitle = reservationPage.getPageHeader();
        Assert.assertTrue((reservationPageTitle.startsWith("Flights from")));
        }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
