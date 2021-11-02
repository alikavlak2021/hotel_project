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

    @FindBy(xpath = "//div[@class='bootbox-body']")
    public WebElement successText;

    @FindBy(xpath = "(//button[@type='button'])[6]")
    public WebElement okButton;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement deleteButton;

    @FindBy(xpath = "//div[@class='bootbox-body']")
    public WebElement wouldYouLikeToContinueText;

    @FindBy(xpath = "(//button[@type='button'])[7]")
    public WebElement wouldYouLikeToContinueOKButton;






    @FindBy(xpath = "//input[@id='Email']")
    public WebElement emailTextBox;

    @FindBy(id = "IDGroup")
    public WebElement hotelTypeDropDown;

    @FindBy(xpath = "//button[@class='btn green']")
    public WebElement saveButton;






}
