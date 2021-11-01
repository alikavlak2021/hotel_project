package com.concorthotel.pages;

import com.concorthotel.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(id = "UserName")
    public WebElement userNameTextBox;

    @FindBy(id = "Password")
    public WebElement passwordTextBox;

    @FindBy(id = "btnSubmit")
    public WebElement loginButton;

    @FindBy(xpath = "//h2[@class='mb-4']")
    public WebElement loginText;

    @FindBy(xpath = "//*[.='Try again please']")
    public WebElement tryAgainText;

}
