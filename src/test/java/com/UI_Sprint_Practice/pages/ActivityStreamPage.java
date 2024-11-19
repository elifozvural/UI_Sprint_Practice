package com.UI_Sprint_Practice.pages;

import com.UI_Sprint_Practice.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ActivityStreamPage {

    public ActivityStreamPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(linkText = "Activity Stream")
    public WebElement activityStreamLink;

    @FindBy(xpath = "//div[@id='feed-add-post-form-tab']/span")
    public List<WebElement> options;

    @FindBy(id = "feed-add-post-form-link-more")
    public WebElement moreButton;

    @FindBy(xpath = " //span[contains(@class,'menu-popup-item-text')]")
    public List<WebElement> optionsUnderMore;



}
