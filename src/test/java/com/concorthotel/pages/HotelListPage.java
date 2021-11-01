package com.concorthotel.pages;

import com.concorthotel.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HotelListPage {
    public HotelListPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//span[@class='caption-subject font-green-sharp bold uppercase']")
    public WebElement listOfHotelsText;

    @FindBy(xpath = "(//a[.=' Details'])[1]")
    public WebElement detailsButton;
}
