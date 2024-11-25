package com.UI_Sprint_Practice.step_definitions;

import com.UI_Sprint_Practice.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefs {

     LoginPage loginPage=new LoginPage();


    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        System.out.println("Login to app in Hooks - Before method");
    }


    @When("the user logged in as {string}")
    public void the_user_logged_in_as(String userType) {

        loginPage.login(userType);

    }


    @Then("user should land on the activity stream page and see the {string} title")
    public void userShouldLandOnTheActivityStreamPageAndSeeTheTitle(String title) {

        Assert.assertEquals(title,loginPage.activityStreamTitle.getText());

    }


    @When("the user logged in with {string} and {string}")
    public void the_user_logged_in_with_and(String userType, String password) {

        loginPage.login(userType,password);

    }


    @Then("user see the error message {string}")
    public void userSeeTheErrorMessage(String expectedErrorMessage) {

        String actualErrorMessage = loginPage.errorMessage.getText();

        Assert.assertEquals(expectedErrorMessage,actualErrorMessage);

    }


    @When("the user enters only {string} or {string}")
    public void theUserEntersOnlyOr(String userType, String password) {

        loginPage.login(userType,password);

    }


    @Then("user see the message {string}")
    public void userSeeTheMessage(String expectedText) {

        String actualErrorText = loginPage.errorMessage.getText();

        Assert.assertEquals(expectedText,actualErrorText);

    }


    @Then("remember me link should be displayed")
    public void rememberMeLinkShouldBeDisplayed() {

        Assert.assertTrue(loginPage.rememberMeCheckbox.isDisplayed());
    }

    @When("user clicks the remember me checkbox")
    public void userClicksTheRememberMeCheckbox() {

        loginPage.rememberMeCheckbox.click();

    }

    @Then("the checkbox should be selected")
    public void theCheckboxShouldBeSelected() {

        Assert.assertTrue(loginPage.rememberMeCheckbox.isSelected());

    }

    @When("user enters a password")
    public void userEntersAPassword() {

        loginPage.passwordBox.sendKeys("UserUser");

    }


    @Then("{string} should be in bullet signs by default")
    public void shouldBeInBulletSignsByDefault(String password) {

        String inputType = loginPage.passwordBox.getAttribute("type");

        Assert.assertEquals(password, inputType);

    }

}
