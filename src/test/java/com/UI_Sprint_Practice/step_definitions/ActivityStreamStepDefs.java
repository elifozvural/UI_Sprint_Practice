package com.UI_Sprint_Practice.step_definitions;

import com.UI_Sprint_Practice.pages.ActivityStreamPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ActivityStreamStepDefs {

    ActivityStreamPage activityStreamPage = new ActivityStreamPage();
    SoftAssertions softly = new SoftAssertions();



    @When("user navigates to activity stream page")
    public void user_navigates_to_activity_stream_page() {

        activityStreamPage.activityStreamLink.click();

    }


    @Then("user views the following options on the activity stream page")
    public void user_views_the_following_options_on_the_activity_stream_page(List<String> expectedOptions) {

        List<String> actualOptions = new ArrayList<>();

        for (WebElement option : activityStreamPage.options) {

            actualOptions.add(option.getText());

        }


        softly.assertThat(actualOptions).isEqualTo(expectedOptions);

        softly.assertAll();


    }


    @When("user clicks MORE button")
    public void user_clicks_more_button() {

        activityStreamPage.moreButton.click();

    }


    @Then("user views the following options under the MORE tab")
    public void user_views_the_following_options_under_the_more_tab(List<String> expectedOptionsUnderMore) {


        List<String> actualOptionsUnderMore = new ArrayList<>();

        for (WebElement options : activityStreamPage.optionsUnderMore) {

            actualOptionsUnderMore.add(options.getText());

        }

        softly.assertThat(actualOptionsUnderMore).isEqualTo(expectedOptionsUnderMore);

        softly.assertAll();


    }




}
