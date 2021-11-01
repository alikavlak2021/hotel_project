package com.concorthotel.tests;

import com.concorthotel.pages.DefaultPage;
import com.concorthotel.pages.LoginPage;
import com.concorthotel.pages.MainPage;
import com.concorthotel.utilities.ConfigReader;
import com.concorthotel.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US_002 {
    LoginPage loginPage = new LoginPage();
    DefaultPage defaultPage = new DefaultPage();
    @Test
    public void mainPageLoginLinkTest(){
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        MainPage mainPage = new MainPage();
        mainPage.loginLink.click();
        Assert.assertTrue(loginPage.loginText.isDisplayed());
    }
    @Test
    public void loginPagePositiveTest(){
        mainPageLoginLinkTest();
        loginPage.userNameTextBox.sendKeys(ConfigReader.getProperty("managerUserName"));
        loginPage.passwordTextBox.sendKeys(ConfigReader.getProperty("managerPassword"));
        loginPage.loginButton.click();
        Assert.assertTrue(defaultPage.managerText.isDisplayed());
        Assert.assertTrue(defaultPage.systemManagementText.isDisplayed());
        Driver.closeDriver();
    }
    @Test
    public void loginPageNegativeTest1(){
        mainPageLoginLinkTest();
        loginPage.userNameTextBox.sendKeys(ConfigReader.getProperty("managerUserName"));
        loginPage.passwordTextBox.sendKeys(ConfigReader.getProperty("invalidManagerPassword"));
        loginPage.loginButton.click();
        Assert.assertTrue(loginPage.tryAgainText.isDisplayed());
        Driver.closeDriver();
    }
    @Test
    public void loginPageNegativeTest2(){
        mainPageLoginLinkTest();
        loginPage.userNameTextBox.sendKeys(ConfigReader.getProperty("invalidManagerUserName"));
        loginPage.passwordTextBox.sendKeys(ConfigReader.getProperty("managerPassword"));
        loginPage.loginButton.click();
        Assert.assertTrue(loginPage.tryAgainText.isDisplayed());
        Driver.closeDriver();
    }
    @Test
    public void loginPageNegativeTest3(){
        mainPageLoginLinkTest();
        loginPage.userNameTextBox.sendKeys(ConfigReader.getProperty("invalidManagerUserName"));
        loginPage.passwordTextBox.sendKeys(ConfigReader.getProperty("invalidManagerPassword"));
        loginPage.loginButton.click();
        Assert.assertTrue(loginPage.tryAgainText.isDisplayed());
        Driver.closeDriver();
    }
}
