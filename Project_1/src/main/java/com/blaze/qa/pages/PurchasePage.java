package com.blaze.qa.pages;

import com.blaze.qa.base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PurchasePage extends BaseTest {

    @FindBy(tagName = "h2")
    WebElement header;

    @FindBy(name = "address")
    WebElement address;

    @FindBy(name = "inputName")
    WebElement name;

    @FindBy(name = "city")
    WebElement city;

    @FindBy(name = "state")
    WebElement state;

    @FindBy(name = "zipCode")
    WebElement zip;

    @FindBy(name = "cardType")
    WebElement card;

    @FindBy(name = "creditCardNumber")
    WebElement CardNos;

    @FindBy(name = "creditCardMonth")
    WebElement cardMonth;

    @FindBy(name = "creditCardYear")
    WebElement cardYear;

    @FindBy(id = "nameOnCard")
    WebElement cardOwner;

    @FindBy(css = "input.btn.btn-primary")
    WebElement purchaseBtn;


    //Initialize Page Objects
    public PurchasePage(){
        PageFactory.initElements(driver, this);
    }

    public String getPageHeader(){
        return header.getText();
    }

    /**
     *
     * @return
     */
    public ConfirmationPage fillUserDetails(){
        name.sendKeys(config_prop.getProperty("Name"));
        address.sendKeys(config_prop.getProperty("Address"));
        city.sendKeys(config_prop.getProperty("city"));
        state.sendKeys(config_prop.getProperty("state"));
        zip.sendKeys(config_prop.getProperty("zip"));
        CardNos.sendKeys(config_prop.getProperty("cardNumber"));
        cardMonth.sendKeys(config_prop.getProperty("cardMonth"));
        cardYear.sendKeys(config_prop.getProperty("cardYear"));
        cardOwner.sendKeys(config_prop.getProperty("cardOwnerName"));
        purchaseBtn.click();
        return new ConfirmationPage();
    }

}
