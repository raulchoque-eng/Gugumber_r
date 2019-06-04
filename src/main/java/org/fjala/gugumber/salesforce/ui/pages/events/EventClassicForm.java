/*
 * @(#) EventClassicForm.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av. Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of Jala
 * Foundation, Inc. ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */

package org.fjala.gugumber.salesforce.ui.pages.events;

import org.fjala.gugumber.core.selenium.utils.DriverMethod;
import org.fjala.gugumber.salesforce.entities.Event;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Date;
import java.util.LinkedList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * EventClassicForm class.
 *
 * @author Raul Choque
 * @version 0.0.1
 */
public class EventClassicForm extends EventForm {

    /**
     * Web element by validate the Event form is open.
     */
    @FindBy(id = "ep")
    private WebElement eventForm;

    /**
     * Web element by search a new user to assign event.
     */
    @FindBy(css = "div#ep > div.pbBody > div:nth-child(4) > table tr:nth-child(1) td:nth-child(2) img.lookupIcon")
    private WebElement searchUserImg;

    /**
     * Web element by the location.
     */
    @FindBy(css = "div#ep div.pbBody > div:nth-child(4) > table tr:nth-child(1) td:nth-child(4) > input")
    private WebElement locationTxt;

    /**
     * Web element by the subject.
     */
    @FindBy(css = "div#ep > div.pbBody > div:nth-child(4) > table tr:nth-child(2) td:nth-child(2) input")
    private WebElement subjectTxt;

    /**
     * Web element by the start date.
     */
    @FindBy(id = "StartDateTime")
    private WebElement startDateTxt;

    /**
     * Web element by the start time.
     */
    @FindBy(id = "StartDateTime_time")
    private WebElement startTimeTxt;

    /**
     * Web element by search the contact.
     */
    @FindBy(css = "div#ep > div.pbBody > div:nth-child(4) > table tr:nth-child(3) td:nth-child(2) select")
    private WebElement nameCmbbx;

    /**
     * Web element by the contact.
     */
    @FindBy(css = "div#ep > div.pbBody > div:nth-child(4) > table tr:nth-child(3) td:nth-child(2) span.lookupInput input")
    private WebElement nameTxt;

    /**
     * Web element by the end date.
     */
    @FindBy(id = "EndDateTime")
    private WebElement endDateTxt;

    /**
     * Web element by the end time.
     */
    @FindBy(id = "EndDateTime_time")
    private WebElement endTimeTxt;

//    /**
//     * Web element by search an related to user.
//     */
//    @FindBy(css = "div#ep > div.pbBody > div:nth-child(4) > table tr:nth-child(6) td:nth-child(2) select")
//    private WebElement relatedToCmbbx;
//
//    /**
//     * Web element by select the related to user.
//     */
//    @FindBy(css = "div#ep > div.pbBody > div:nth-child(4) > table tr:nth-child(6) td:nth-child(2) span.lookupInput [title=\"Related To\"]")
//    private WebElement relatedToTxt;

    /**
     * Web element by the Description.
     */
    @FindBy(css = "td.last.data2Col > textarea")
    private WebElement descriptionTxtar;

    /**
     * Web element by the event save.
     */
    @FindBy(css = "td#topButtonRow [value = \" Save \"]")
    private WebElement saveEventBtn;

    /**
     * Creates a new Event with the event information.
     *
     * @param event    is a event to get the information.
     * @param keyEvent is a set of key of references.
     */
    @Override
    public void createEvent(final Event event, final Set<String> keyEvent) {
        setAssignedToUser(event.getAssignedToUser());
        setLocation(event.getLocation());
        setSubject(event.getSubject());
        setNameContact(event.getNameContact());
        setDescription(event.getDescription());
    }
//
//    @Override
//    public EventForm getEventForm() {
//        return new EventClassicForm();
//    }

    /**
     * Waits until the Event classical form is uploaded.
     */
    @Override
    protected void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(eventForm));
    }

    /**
     * Sets the assignedToUser in a Event classic form sending a string.
     *
     * @param assignedToUser as a string.
     */
    public void setAssignedToUser(final String assignedToUser) {
        searchUserImg.click();
        String parentWindowHandle = driver.getWindowHandle();
        Set<String> windows = driver.getWindowHandles();
        driver.switchTo().window(new LinkedList<>(windows).getLast());
        driver.switchTo().frame("resultsFrame");
        driver.findElement(By.cssSelector("table.list tr:nth-child(2) th:nth-child(1) a")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.switchTo().window(parentWindowHandle);
    }

    /**
     * Sets the location in a Event classic form sending a string.
     *
     * @param location as a string.
     */
    public void setLocation(final String location) {
        DriverMethod.setTxt(locationTxt, location);
    }

    /**
     * Sets the subject in a Event classic form sending a string.
     *
     * @param subject as a string.
     */
    public void setSubject(final String subject) {
        DriverMethod.setTxt(subjectTxt, subject);
    }

    /**
     * Sets the startDate in a Event classic form sending a string by validate the date.
     *
     * @param startDate as a Date.
     */
    public void setStarDate(final Date startDate) {
    }


    /**
     * Sets the nameContact in a Event classic form sending a string.
     *
     * @param nameContact as a string.
     */
    public void setNameContact(final String nameContact) {

        DriverMethod.setTxt(nameTxt, nameContact);
    }

    /**
     * Sets the endDate in a Event classic form sending a string by validate the date.
     *
     * @param endDate as a Date.
     */
    public void setEndDate(final Date endDate) {
    }

    /**
     * Sets the description in a Event classic form sending a string.
     *
     * @param description as a string.
     */
    public void setDescription(final String description) {
        DriverMethod.setTxt(descriptionTxtar, description);
    }
}
