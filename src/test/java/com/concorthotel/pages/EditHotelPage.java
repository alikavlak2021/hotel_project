package com.concorthotel.pages;

import com.concorthotel.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditHotelPage {
    public EditHotelPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//div[@class='caption']")
    public WebElement editHotelText;

    @FindBy(xpath = "//input[@id='Code']")
    public WebElement codeTextBox;

    @FindBy(xpath = "//input[@id='Name']")
    public WebElement nameTextBox;

    @FindBy(xpath = "//input[@id='Address']")
    public WebElement addressTextBox;

    @FindBy(xpath = "//input[@id='Phone']")
    public WebElement phoneTextBox;

    @FindBy(xpath = "//input[@id='Email']")
    public WebElement emailTextBox;

    @FindBy(id = "IDGroup")
    public WebElement hotelTypeDropDown;

    @FindBy(xpath = "//button[@class='btn green']")
    public WebElement saveButton;






}
