package com.concorthotel.tests;

import com.concorthotel.pages.*;
import com.concorthotel.utilities.ConfigReader;
import com.concorthotel.utilities.Driver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class US_005 {
    LoginPage loginPage = new LoginPage();
    DefaultPage defaultPage = new DefaultPage();
    MainPage mainPage = new MainPage();
    HotelListPage hotelListPage = new HotelListPage();
    EditHotelPage editHotelPage = new EditHotelPage();
    @BeforeMethod
    public void setUp(){
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        mainPage.loginLink.click();
        Assert.assertTrue(loginPage.loginText.isDisplayed());
        loginPage.userNameTextBox.sendKeys(ConfigReader.getProperty("managerUserName"));
        loginPage.passwordTextBox.sendKeys(ConfigReader.getProperty("managerPassword"));
        loginPage.loginButton.click();
        Assert.assertTrue(defaultPage.managerText.isDisplayed());
        Assert.assertTrue(defaultPage.systemManagementText.isDisplayed());
    }
    @Test
    public void updateHotelInfoTest(){
        defaultPage.hotelManagementLink.click();
        defaultPage.hotelListLink.click();
        Assert.assertTrue(hotelListPage.listOfHotelsText.isDisplayed());
        hotelListPage.detailsButton.click();
        Assert.assertTrue(editHotelPage.editHotelText.isDisplayed());

    }
    @Test
    public void editHotelPageTest() throws InterruptedException {
        updateHotelInfoTest();
        Thread.sleep(2000);
        editHotelPage.codeTextBox.clear();
        Thread.sleep(2000);
        editHotelPage.codeTextBox.sendKeys("1234");
        editHotelPage.nameTextBox.clear();
        editHotelPage.nameTextBox.sendKeys("Hilton");
        editHotelPage.addressTextBox.clear();
        editHotelPage.addressTextBox.sendKeys("Norway");
        editHotelPage.phoneTextBox.clear();
        editHotelPage.phoneTextBox.sendKeys("+47-456-32-211");
        editHotelPage.emailTextBox.clear();
        editHotelPage.emailTextBox.sendKeys("ece@gmail.com");
        Select select = new Select(editHotelPage.hotelTypeDropDown);
        select.selectByValue("1");
        editHotelPage.saveButton.click();

    }
}
