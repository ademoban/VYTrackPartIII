package com.vytrack.tests.components.dashboards;

import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ActivitiesPage {

    /*
    String dailyselection = "[id^=recurrence-repeats-]";
    String daysCheckBox = "//input[@type='radio'][@checked='checked']";
   String numberLocator = "[name^='temp-validation-name-']";
     */

    @FindBy(css = "[id^=recurrence-repeats-]")
        public WebElement dropdown;

    public void activitiesPages(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
}
