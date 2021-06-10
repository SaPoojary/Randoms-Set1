package com.blaze.qa.pages;

import com.blaze.qa.base.BaseTest;
import com.blaze.qa.utils.TestUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseTest {
//PageFactory - OR

    @FindBy(name = "fromPort")
    WebElement sourceCity;

    @FindBy(name = "toPort")
    WebElement destinationCity;

    @FindBy(css = "input.btn.btn-primary")
    WebElement find_btn;

    //Initialize Page Objects
    public HomePage(){
        PageFactory.initElements(driver, this);
    }

    //Actions
    public ReservationPage book_flight(String fromCity, String toCity){
        TestUtils.select_from_dropdown(sourceCity,fromCity);
        TestUtils.select_from_dropdown(destinationCity,toCity);
        find_btn.click();
        return new ReservationPage();
    }

    public String get_homePageTitle(){
        return driver.getTitle();
    }

    public void verifyHomeLink(){
        //To do
    }

    public void get_links_on_pqge(){
        //To do
    }
}
