package com.blaze.qa.pages;

import com.blaze.qa.base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmationPage extends BaseTest {

    @FindBy(tagName = "h1")
    WebElement header;

    //Initialize Page Objects
    public ConfirmationPage(){
        PageFactory.initElements(driver, this);
    }

    public String getPageHeader(){
        return header.getText();
    }
}
