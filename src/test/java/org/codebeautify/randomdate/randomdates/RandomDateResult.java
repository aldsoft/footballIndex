package org.codebeautify.randomdate.randomdates;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.steps.UIInteractionSteps;
import org.openqa.selenium.By;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RandomDateResult extends UIInteractionSteps {

      static By DATE_RESULT = By.cssSelector("#cbBody > div.row > div > div > div > div > div.body.firstcolmn-1 > div.sides-wrapper.clearfix > div > div > div > div.data-wrapper > textarea");

    private String getTextArea() {
        return $(DATE_RESULT).getValue();
    }

    public List<String> getgeneratedDatesAsList() {
        return Arrays.asList(getTextArea().split("\n"));

    }
}
