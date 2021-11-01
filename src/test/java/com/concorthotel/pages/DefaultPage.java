package com.concorthotel.pages;

import com.concorthotel.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DefaultPage {
    public DefaultPage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//span[@class='username username-hide-on-mobile']")
    public WebElement managerText;

    @FindBy(xpath = "//span[@class='title']")
    public WebElement systemManagementText;

    @FindBy(xpath = "(//span[@class='title'])[3]")
    public WebElement hotelManagementLink;

    @FindBy(partialLinkText = "Hotel List")
    public WebElement hotelListLink;
}
