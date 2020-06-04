package org.codebeautify.randomdate.randomdates;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.codebeautify.randomdate.Sleep;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;


public class CalenderDateOptions extends UIInteractionSteps {
    static By HOW_MANY_DATES = By.id("option-count-147fe348");
    static By OUTPUT_DATE_FORMAT = By.id("option-format-147fe348");
    static By CUSTOM_DATE_FORMAT = By.id("option-custom-format-147fe348");
    static By START_DATE = By.id("option-start-147fe348");
    static By END_DATE = By.id("option-end-147fe348");
    static By GENERATE_DATES = By.cssSelector("#cbBody > div.row > div > div > div > div > div.body.firstcolmn-1 > div.sides-primary-button > button");


    @Step("set how many dates {0}")
    public void setHowManyDates(String count) {
        $(HOW_MANY_DATES).clear();
        $(HOW_MANY_DATES).type(count);
    }

    public String getHowManyDates() {
        return $(HOW_MANY_DATES).getValue();
    }

    @Step("set output date format {0}")
    public void setDateOutputFormat(String dateOutputFormat) {
        $(OUTPUT_DATE_FORMAT).selectByVisibleText(dateOutputFormat);
    }

    public String getDateOutputFormat() {
        return $(OUTPUT_DATE_FORMAT).getSelectedVisibleTextValue();
    }

    @Step("set start date {0}")
    public void setStartDate(String startDate) {
        $(START_DATE).clear();
        $(START_DATE).type(startDate);
    }

    public String getStartDate() {
        return $(START_DATE).getValue();
    }

    @Step("set end date {0}")
    public void setEndDate(String endDate) {
        $(END_DATE).clear();
        $(END_DATE).type(endDate);
    }

    public String getEndDate() {
        return $(END_DATE).getValue();
    }

    @Step("click generate dates button")
    public void generateDates() {
        $(GENERATE_DATES).click();
        Sleep.sleepfor(10000);
    }

    public void waitForJStoLoad() {
        waitFor(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                try {
                    return ((Long)evaluateJavascript("return jQuery.active") == 0);
                }
                catch (Exception e) {
                    return true;
                }
            }
        });

        waitFor(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return evaluateJavascript("return document.readyState")
                        .toString().equals("complete");
            }
        });
    }
}
