package com.UI_Sprint_Practice.pages;

import com.UI_Sprint_Practice.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AppreciationPage {

    public AppreciationPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//span[.='Appreciation']")
    public WebElement appreciationButton;

    @FindBy(css = ".bx-editor-iframe")
    public WebElement iframeElement;

    @FindBy(xpath = "//body[@contenteditable='true']")
    public WebElement textBox;

    @FindBy(id = "blog-submit-button-save")
    public WebElement sendButton;

    @FindBy(xpath = "(//*[contains(@id,'blg-post-img-')])[1]")
    public WebElement appreciationInTheFeed;

    @FindBy(css = ".feed-add-info-text")
    public WebElement errorMessage;

    @FindBy(css = ".feed-add-post-del-but")
    public WebElement allEmpDeleteButton;

    @FindBy(xpath = "//span[@class='feed-add-post-destination-text']")
    public WebElement allEmployees;


    @FindBy(id = "blog-submit-button-cancel")
    public WebElement cancelButton;

}
