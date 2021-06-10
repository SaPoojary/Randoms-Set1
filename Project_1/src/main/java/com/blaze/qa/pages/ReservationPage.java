package com.blaze.qa.pages;

import com.blaze.qa.base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReservationPage extends BaseTest {

    @FindBy(tagName = "h3")
    WebElement header;

    @FindBy(xpath = "//tbody/tr[1]/td[1]/input[1]")
    WebElement chooseFlightBtn;

    //Initialize Page Objects
    public ReservationPage(){
        PageFactory.initElements(driver, this);
    }

    public String getPageHeader(){
        return header.getText();
    }

    public PurchasePage selectFlight(){
        chooseFlightBtn.click();
        return  new PurchasePage();
    }
}
