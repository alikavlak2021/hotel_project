package com.concorthotel.tests;

import com.concorthotel.pages.DefaultPage;
import com.concorthotel.pages.EditHotelRoomPage;
import com.concorthotel.pages.LoginPage;
import com.concorthotel.pages.MainPage;
import com.concorthotel.utilities.ConfigReader;
import com.concorthotel.utilities.Driver;
import org.apache.hc.core5.reactor.Command;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class US_006 {
    MainPage mainPage = new MainPage();
    LoginPage loginPage = new LoginPage();
    DefaultPage defaultPage = new DefaultPage();
    EditHotelRoomPage editHotelRoomPage = new EditHotelRoomPage();


    @Test
   public void TC_000(){
       Driver.getDriver().get(ConfigReader.getProperty("app1_url"));

       String expectedLoginText = "Log in";
       String actualLoginText = Driver.getDriver().findElement(By.xpath("(//a[@class ='nav-link'])[7]")).getText();
        Assert.assertEquals(actualLoginText,expectedLoginText);
         mainPage.loginLink.click();
        loginPage.userNameTextBox.sendKeys(ConfigReader.getProperty("manager_userId"));
        loginPage.passwordTextBox.sendKeys(ConfigReader.getProperty("manager_userPassword"));
        loginPage.loginButton.click();

   }

   @Test
    public void TC_001(){

       String  expectLinkedText= "Hotel Management";
       String actualLinkedText = Driver.getDriver().findElement(By.partialLinkText("Hotel Management")).getText();
       Assert.assertEquals(expectLinkedText,actualLinkedText);
    defaultPage.hotelManagementLink.click();
   }
    @Test
    public void TC_002(){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
        WebElement assertionElement = wait.until(ExpectedConditions.visibilityOf(defaultPage.hotelRoomsTab));
        String  expectHotelRoomsText= "Hotel Rooms";
        String actualHotelRoomsText = Driver.getDriver().findElement(By.partialLinkText("Hotel Rooms")).getText();
        Assert.assertEquals(expectHotelRoomsText,actualHotelRoomsText);
        defaultPage.hotelRoomsTab.click();

    }
    @Test
    public void TC_003(){
        //1. GIVEN "ADD HOTELROOM" should be visible

            Assert.assertEquals(Driver.getDriver().
                    findElement(By.partialLinkText("ADD HOTELROOM")).getText(),"ADD HOTELROOM");
            editHotelRoomPage.addHotelRoomLink.click();
            // Creteria da yok
            Assert.assertEquals(Driver.getDriver().
                    findElement(By.xpath("//div[@class='caption']")).getText(),"Create Hotelroom");

        // 2. AND  Hotel name should be able to Select from the dropdown
        Select select = new Select(editHotelRoomPage.iDHotel);
        select.selectByVisibleText("Fatih Otel");

    }
    @Test
    public void TC_004(){

editHotelRoomPage.code.sendKeys(ConfigReader.getProperty("code"));
editHotelRoomPage.name.sendKeys(ConfigReader.getProperty("Name"));
editHotelRoomPage.location.sendKeys(ConfigReader.getProperty("Location"));
editHotelRoomPage.textArea.sendKeys(ConfigReader.getProperty("Description"));

    }
    @Test
    public void TC_005(){
       // 1. GIVEN Price section must be visible
        Assert.assertTrue(Driver.getDriver().
                findElement(By.xpath("//div[@class='ui-widget-content']")).isDisplayed());
       // 2. THEN must be able to write or drag and drop price into given BOX
        editHotelRoomPage.price.sendKeys(ConfigReader.getProperty("Out_Of_Price_List"));
        //Element which needs to drag.
        WebElement From=Driver.getDriver().findElement(By.xpath("(//a[@class='label label-success'])[6]"));
        //Element on which need to drop.
        WebElement To=Driver.getDriver().findElement(By.id("Price"));
        //Using Action class for drag and drop.
        Actions act=new Actions(Driver.getDriver());
        //Dragged and dropped.
        act.dragAndDrop(From, To).build().perform();

        WebElement From600=Driver.getDriver().findElement(By.xpath("(//a[@class='label label-success'])[5]"));
        act.dragAndDrop(From600, To).build().perform();
        WebElement From500=Driver.getDriver().findElement(By.xpath("(//a[@class='label label-success'])[4]"));
        act.dragAndDrop(From500, To).build().perform();
        WebElement From400=Driver.getDriver().findElement(By.xpath("(//a[@class='label label-success'])[3]"));
        act.dragAndDrop(From400, To).build().perform();
        WebElement From300=Driver.getDriver().findElement(By.xpath("(//a[@class='label label-success'])[2]"));
        act.dragAndDrop(From300, To).build().perform();
        WebElement From200=Driver.getDriver().findElement(By.xpath("(//a[@class='label label-success'])[1]"));
        act.dragAndDrop(From200, To).build().perform();

    }
    @Test
    public void TC_006(){
        //1. GIVEN "Room Type"  should be visible
        Assert.assertTrue(Driver.getDriver().findElement(By.id("IDGroupRoomType")).isDisplayed());
        //2. AND select the "Room Type" from dropdown list into the given Box

        Select select = new Select(Driver.getDriver().findElement(By.id("IDGroupRoomType")));
        select.selectByIndex(2);

    }

@Test
public void TC_007(){
    Assert.assertTrue(Driver.getDriver().findElement(By.id("MaxAdultCount")).isDisplayed());
    //Positive Test

        editHotelRoomPage.maxAdultCount.sendKeys(ConfigReader.getProperty("MaxAdultCount"));
    //Negative Test
    editHotelRoomPage.maxAdultCount.sendKeys(ConfigReader.getProperty("Max_Adult_Count_Negative"));
    System.out.println("Must be a Limitation :"+ConfigReader.getProperty("Max_Adult_Count_Negative"));
    //Positive Test
    Assert.assertTrue(Driver.getDriver().findElement(By.id("MaxChildCount")).isDisplayed());
    editHotelRoomPage.maxChildCount.sendKeys(ConfigReader.getProperty("MaxChildCount"));
    //Negative Test
    editHotelRoomPage.maxChildCount.sendKeys(ConfigReader.getProperty("Max_Child_Count_Negative"));

    System.out.println("Must be a Limitation :"+ConfigReader.getProperty("Max_Child_Count_Negative"));
}
@Test
public void TC_008(){
Assert.assertFalse(Driver.getDriver().findElement(By.id("IsAvailable")).isDisplayed());
WebElement checkBox = Driver.getDriver().findElement(By.id("IsAvailable"));
if(!checkBox.isSelected()){
    checkBox.click();
    Assert.assertTrue(checkBox.isSelected());

}
Assert.assertTrue(Driver.getDriver().findElement(By.id("btnSubmit")).isEnabled());
editHotelRoomPage.btnSubmit.click();

}
@Test
public void TC_009(){
Assert.assertFalse(Driver.getDriver().findElement(By.xpath("(//button[@type='button'])[6]")).isDisplayed());
editHotelRoomPage.okButton.click();
}

    @AfterClass
    public void tearDown(){
       Driver.closeDriver();
    }


}
