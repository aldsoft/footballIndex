package org.codebeautify.randomdate.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.apache.commons.validator.GenericValidator;
import org.assertj.core.api.SoftAssertions;
import org.codebeautify.randomdate.navigation.NavigateTo;
import org.codebeautify.randomdate.randomdates.CalenderDateOptions;
import org.codebeautify.randomdate.randomdates.RandomDateResult;
import org.junit.Assert;
import org.yecht.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RandomDateGeneratorSteps {

    @Steps
    NavigateTo navigateTo;

    @Steps
    CalenderDateOptions calenderDateOptions;

    @Steps
    RandomDateResult randomDateResult;

    @Given("^(?:.*) is on the RandomDateGenerator home page")
    public void i_am_on_the_RandomDateGenerator_home_page() {
        navigateTo.theRandomDateGeneratorHomePage();
    }

    @And("^s?he wants to generate (.*) random dates")
    public void i_set_how_many_dates_to_generate(String count) {
        calenderDateOptions.setHowManyDates(count);
    }

    @And("^s?he selects the output date format \"(.*)\"")
    public void i_select_output_date_format(String ouputDateFormat) {
        calenderDateOptions.setDateOutputFormat(ouputDateFormat);
    }

    @And("^s?he sets the start date as \"(.*)\"")
    public void i_set_the_start_date(String startDate) {
        calenderDateOptions.setStartDate(startDate);
    }

    @And("^s?he sets the end date as \"(.*)\"")
    public void i_set_the_end_date(String endDate) {
        calenderDateOptions.setEndDate(endDate);
    }

    @When("^he clicks generate random dates$")
    public void i_click_generate_random_date_button() {
        calenderDateOptions.generateDates();
    }

    @Then("^the random dates are generated successfully$")
    public void verifyRandomDates() {
        List<String> genDates = randomDateResult.getgeneratedDatesAsList();


        SoftAssertions softly = new SoftAssertions();

        softly.assertThat(genDates.size())
                .as("number of generated dates")
                .isEqualTo(Integer.parseInt(calenderDateOptions.getHowManyDates()));


        String dateFormatExpected = calenderDateOptions.getDateOutputFormat().trim();

        if(dateFormatExpected.equals("YYYY-MM-DD hh:mm:ss")
                || dateFormatExpected.equals("YYYY-DD-MM hh:mm:ss")
                || dateFormatExpected.equals("MM-DD-YYYY hh:mm:ss")){

            String dateFormatExpectedReplaced = dateFormatExpected
                    .replace("DD" , "dd")
                    .replace("YYYY", "yyyy")
                    .replace("hh", "HH");

            //Verify if all the generated dates are valid dates and are of correct format
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormatExpectedReplaced);
            genDates.stream().forEach(date ->  {
                // verify date time format
                VerifyDateFormat1(date, dateFormatExpectedReplaced);
                try {
                    //parse the date using the expected format
                    String parsedDateTime = LocalDateTime
                            .parse(date, formatter)
                            .format(formatter);
                    //compare the parsed date with the generated random date
                    softly.assertThat(parsedDateTime)
                            .as("generated random date "+ date + " is nvalid" + dateFormatExpected )
                            .isEqualTo(date);
                } catch (Exception e) {
                    softly.fail("generated random date "+ date + " is invalid");
                    throw e;
                }
            });

            softly.assertAll();
        }



    }

    @Step
    private void VerifyDateFormat1(String date, String dateFormatExpected) {
        SoftAssertions softly = new SoftAssertions();
        List<String> splittedDateFormat = Arrays.asList(dateFormatExpected.split("[- :]"));
        List<String> splittedGeneratedDate = Arrays.asList(date.split("[- :]"));

        softly.assertThat(splittedGeneratedDate.size())
                .as("all date time formats included in generated date")
                .isEqualTo(splittedDateFormat.size());

        for (int i=0; i< splittedDateFormat.size(); i++) {
            softly.assertThat(splittedGeneratedDate.get(i).length())
                    .as("checking format " + splittedDateFormat.get(i)
                            + " of " + dateFormatExpected + " in generated date")
                    .isEqualTo(splittedDateFormat.get(i).length());

        }

        softly.assertAll();
    }


}
