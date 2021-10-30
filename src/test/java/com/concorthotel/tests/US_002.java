package com.concorthotel.tests;

import com.concorthotel.pages.MainPage;
import com.concorthotel.utilities.ConfigReader;
import com.concorthotel.utilities.Driver;
import org.testng.annotations.Test;

public class US_002 {
    @Test
    public void mainPageLoginLinkTest(){
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        MainPage mainPage = new MainPage();
        mainPage.loginLink.click();
    }
}
