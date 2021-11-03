package com.concorthotel.pages;

import com.concorthotel.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class EditHotelRoomPage {
    public EditHotelRoomPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//span[@class='hidden-480']")
    public WebElement addHotelRoomLink;

    @FindBy(id = "IDHotel")
    public WebElement iDHotel;

    @FindBy(id = "Code")
    public WebElement code;

    @FindBy(id = "Name")
    public WebElement name;

    @FindBy(id = "Location")
    public WebElement location;

    @FindBy(xpath = "//textarea[@dir='ltr']")
    public WebElement textArea;

    @FindBy(id = "Price")
    public WebElement price;

    @FindBy(id = "MaxAdultCount")
    public WebElement maxAdultCount;

    @FindBy(id = "MaxChildCount")
    public WebElement maxChildCount;


    @FindBy(id = "btnSubmit")
    public WebElement btnSubmit;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    public WebElement okButton;

}

