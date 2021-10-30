package com.concorthotel.tests;

import com.concorthotel.pages.LoginPage;
import com.concorthotel.pages.MainPage;
import com.concorthotel.utilities.ConfigReader;
import com.concorthotel.utilities.Driver;
import org.testng.annotations.Test;

public class US_002 {
    LoginPage loginPage = new LoginPage();
    @Test
    public void mainPageLoginLinkTest(){
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        MainPage mainPage = new MainPage();
        mainPage.loginLink.click();
    }
    @Test
    public void loginPagePositiveTest(){
        mainPageLoginLinkTest();
        loginPage.userNameTextBox.sendKeys(ConfigReader.getProperty("managerUserName"));
        loginPage.passwordTextBox.sendKeys(ConfigReader.getProperty("managerPassword"));
        loginPage.loginButton.click();
    }
}
