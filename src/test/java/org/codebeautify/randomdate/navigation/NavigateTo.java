package org.codebeautify.randomdate.navigation;

import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import org.codebeautify.randomdate.Sleep;
import org.codebeautify.randomdate.homepage.RandomDateGeneratorPage;
import org.codebeautify.randomdate.randomdates.CalenderDateOptions;

public class NavigateTo {
    RandomDateGeneratorPage randomDateGeneratorPage;
    CalenderDateOptions calenderDateOptions;

    @Step("Navigate to the random date generator page")
    public void theRandomDateGeneratorHomePage() {
        randomDateGeneratorPage.open();
        Sleep.sleepfor(5000);

    }

    public void setCalenderOptionSessionVariables() {
        Serenity.setSessionVariable("generateCount").to(calenderDateOptions.getHowManyDates());
        Serenity.setSessionVariable("outputDateFormat").to(calenderDateOptions.getDateOutputFormat());
        Serenity.setSessionVariable("startDate").to(calenderDateOptions.getStartDate());
        Serenity.setSessionVariable("endDate").to(calenderDateOptions.getEndDate());
    }
}
