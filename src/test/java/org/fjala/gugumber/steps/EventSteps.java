/*
 * @(#) EventSteps.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av. Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of Jala
 * Foundation, Inc. ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */

package org.fjala.gugumber.steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fjala.gugumber.salesforce.entities.Context;
import org.fjala.gugumber.salesforce.entities.Event;
import org.fjala.gugumber.salesforce.ui.PageLayoutConfig;
import org.fjala.gugumber.salesforce.ui.PageLayoutType;
import org.fjala.gugumber.salesforce.ui.PageTransporter;
import org.fjala.gugumber.salesforce.ui.pages.events.EventDetailPage;
import org.fjala.gugumber.salesforce.ui.pages.events.EventForm;
import org.fjala.gugumber.salesforce.ui.pages.events.CalendarLightningPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Map;
import java.util.Set;

import static org.fjala.gugumber.salesforce.ui.PageLayoutType.CLASSIC;
import org.fjala.gugumber.salesforce.ui.pages.Home.HomePage;

/**
 * EventSteps class
 *
 * @author Raúl Choque
 * @version 0.0.1
 */
public class EventSteps {
    private EventForm eventForm;
    private Event event;
    private HomePage homePage;
    private EventDetailPage eventDetailPage;
    private CalendarLightningPage calendarPage;

    public EventSteps(Context context) {
        this.event = context.getEvent();
    }

    @When("^I open the form Event from Home page$")
    public void openFormEvent() {
        PageLayoutType layout = PageLayoutConfig.getPageLayoutName();
        if (layout == CLASSIC) {
//            homePage = new HomeClassicPage();
            eventForm = homePage.openEventForm();
        } else {
            calendarPage =PageTransporter.getInstance().navigateToCalendarPage();
            eventForm = calendarPage.openEventForm();
        }
    }

    @When("^I add a new Event with the following data$")
    public void addNewEvent(Map<String, String> newEvent) {
        event.setDataToEvent(newEvent);
        Set<String> keysEvent = newEvent.keySet();
        eventForm.createEvent(event, keysEvent);
    }

    @Then("^the Subject of new Event should be displayed on Calendar Section$")
    public void validateNameEvent() {
        assertEquals(homePage.getNameEvent(), event.getNameContact());
    }

    @When("^I open the new Event$")
    public void openEventDetail() {
        homePage.openDetail();
    }

    @Then("^the data of new Event should be displayed from Event Detail page$")
    public void validateEventDetail() {
        assertTrue(eventDetailPage.isEqualTo(event));
    }
}
