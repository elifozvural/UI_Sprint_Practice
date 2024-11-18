package com.UI_Sprint_Practice.pages;


import com.UI_Sprint_Practice.utilities.ConfigurationReader;
import com.UI_Sprint_Practice.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(name="USER_LOGIN")
    public WebElement userNameBox;



    @FindBy(name="USER_PASSWORD")
    public WebElement passwordBox;

    @FindBy(className = "login-btn")
    public WebElement loginButton;

    @FindBy(css = "div[id='pagetitle']")
    public WebElement activityStreamTitle;

    @FindBy (className = "errortext")
    public WebElement errorMessage;

    @FindBy(className = "login-item-checkbox-label")
    public WebElement rememberMeText;

    @FindBy(id = "USER_REMEMBER")
    public WebElement rememberMeButton;


    public void login(String usertype) {

        if (usertype.equalsIgnoreCase("hr")){
            userNameBox.sendKeys(ConfigurationReader.getProperty("hr_username"));
        }else if(usertype.equalsIgnoreCase("helpdesk")){
            userNameBox.sendKeys(ConfigurationReader.getProperty("helpdesk_username"));
        }else {
            userNameBox.sendKeys(ConfigurationReader.getProperty("marketing_username"));
        }
        passwordBox.sendKeys(ConfigurationReader.getProperty("password"));
        loginButton.click();

    }


    public void login(String username, String password) {

        userNameBox.sendKeys(username);
        passwordBox.sendKeys(password);
        loginButton.click();


    }




}
