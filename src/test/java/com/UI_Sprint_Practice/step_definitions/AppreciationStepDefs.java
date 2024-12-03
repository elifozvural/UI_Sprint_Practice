package com.UI_Sprint_Practice.step_definitions;

import com.UI_Sprint_Practice.pages.ActivityStreamPage;
import com.UI_Sprint_Practice.pages.AppreciationPage;
import com.UI_Sprint_Practice.utilities.BrowserUtils;
import com.UI_Sprint_Practice.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class AppreciationStepDefs {

    AppreciationPage appreciationPage = new AppreciationPage();
    ActivityStreamPage activityStreamPage = new ActivityStreamPage();

    @When("user navigates to Appreciation tab")
    public void user_navigates_to_appreciation_tab() {

        activityStreamPage.activityStreamLink.click();

        activityStreamPage.moreButton.click();

        appreciationPage.appreciationButton.click();

    }

    @And("user enters a message {string}")
    public void userEntersAMessage(String message) {

        Driver.getDriver().switchTo().frame(appreciationPage.iframeElement);

        appreciationPage.textBox.sendKeys(message);

        Driver.getDriver().switchTo().defaultContent();

    }


    @And("user clicks send")
    public void userClicksSend() {

        appreciationPage.sendButton.click();

    }

    @Then("user sees the appreciation that is sent")
    public void userSeesTheAppreciationThatIsSent() {

        Driver.getDriver().navigate().refresh();

        Assert.assertTrue(appreciationPage.appreciationInTheFeed.isDisplayed());

    }


    @Then("user sees the error message for the message field {string}")
    public void userSeesTheErrorMessageForTheMessageField(String expectedErrorMessage) {

        String actualErrorMessage = appreciationPage.errorMessage.getText();

        Assert.assertEquals(expectedErrorMessage,actualErrorMessage);

    }

    @And("user deselects All employees")
    public void userDeselectsAllEmployees() {
        appreciationPage.allEmpDeleteButton.click();
    }

    @Then("user sees the error message for the recipient field {string}")
    public void userSeesTheErrorMessageForTheRecipientField(String expectedErrorMessage) {

        String actualErrorMessage = appreciationPage.errorMessage.getText();

        Assert.assertEquals(expectedErrorMessage,actualErrorMessage);

    }

    @Then("user sees the delivery is {string} by default.")
    public void userSeesTheDeliveryIsAllEmployeesByDefault(String expectedDeliveryOption) {

        BrowserUtils.sleep(2);
        String actualDeliveryOption = appreciationPage.allEmployees.getText();
        Assert.assertEquals(expectedDeliveryOption,actualDeliveryOption);


    }


    @And("user cancels appreciation")
    public void userCancelsAppreciation() {

        appreciationPage.cancelButton.click();

    }

    @Then("users see the {string} text in the activity stream")
    public void usersSeeTheTextInTheActivityStream(String expectedText) {


        String actualText = activityStreamPage.sendMessageText.getText();

        Assert.assertTrue(activityStreamPage.sendMessageText.isDisplayed());
        Assert.assertEquals(expectedText, actualText);

    }


    @And("user enters the message {string} which fewer than 500 characters")
    public void userEntersTheMessageWhichFewerThanCharacters(String message) {

        Driver.getDriver().switchTo().frame(appreciationPage.iframeElement);

        appreciationPage.textBox.sendKeys(message);

        Driver.getDriver().switchTo().defaultContent();



    }

    @Then("user sees the appreciation is not sent")
    public void userSeesTheAppreciationIsNotSent() {

        Assert.assertFalse(appreciationPage.appreciationInTheFeed.isDisplayed());


    }


}