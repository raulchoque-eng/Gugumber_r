/*
 * @(#) EventLightningForm.java Copyright (c) 2019 Jala Foundation.
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

import org.fjala.gugumber.core.StrategySetter;
import org.fjala.gugumber.core.selenium.utils.DriverMethod;
import org.fjala.gugumber.core.selenium.utils.DriverMethods;
import org.fjala.gugumber.salesforce.entities.Event;
import org.fjala.gugumber.salesforce.utils.DateMethods;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Date;
import java.util.HashMap;
import java.util.Set;

/**
 * EventLightningForm class.
 *
 * @author Raul Choque
 * @version 0.0.1
 */
public class EventLightningForm extends EventForm {


    /**
     * Web element by validate the Event form is open..
     */
    @FindBy(css = "div.modal-header h2.title")
    private WebElement titleFormLbl;

    /**
     * Web element by the event form.
     */
    @FindBy(css = "div.modal-container slds-modal__container")
    private WebElement eventForm;

    /**
     * Web element by search a new user to assign event.
     */
    @FindBy(css = "div.uiInput a.deleteAction")
    private WebElement closeLnk;

    /**
     * Web element by the subject.
     */
    @FindBy(css = "div.modal-body input[id ^= \"input\"]")
    private WebElement subjectTxt;

    /**
     * Web element by the contact.
     */
    @FindBy(css = "div.modal-body input[title = \"Search Contacts\"]")
    private WebElement contactCmbbx;

    /**
     * Web element by the account.
     */
    @FindBy(css = "div.modal-body input[title = \"Search Accounts\"]")
    private WebElement accountCmbbx;

    /**
     * Web element by the location.
     */
    @FindBy(css = "div.modal-body div.uiInputText input.input")
    private WebElement locationTxt;

    /**
     * Web element by the start date.
     */
    @FindBy(css = "div.modal-body div.slds-grid.slds-gutters_small:nth-of-type(2) div.dateTime-inputDate input")
    private WebElement startDateTxt;

    /**
     * Web element by the start time.
     */
    @FindBy(css = "div.modal-body div.slds-grid.slds-gutters_small:nth-of-type(2) div.dateTime-inputTime input")
    private WebElement startTimeTxt;

    /**
     * Web element by the end date.
     */
    @FindBy(css = "div.modal-body div.slds-grid.slds-gutters_small:nth-of-type(3) div.dateTime-inputDate input")
    private WebElement endDateTxt;

    /**
     * Web element by the end time.
     */
    @FindBy(css = "div.modal-body div.slds-grid.slds-gutters_small:nth-of-type(3) div.dateTime-inputTime input")
    private WebElement endTimeTxt;

    /**
     * Web element by check all days.
     */
    @FindBy(css = "div.modal-body input[type = \"checkbox\"]")
    private WebElement allDaysCbox;

    /**
     * Web element by the description.
     */
    @FindBy(css = "span#quickTextKeyboardTip ~ textarea")
    private WebElement descriptionTxtar;

    /**
     * Web element by the save the new event.
     */
    @FindBy(css = "div.modal-footer button[title=\"Save\"]")
    private WebElement saveBtn;

    /**
     * Waits until the event form is loaded.
     */
    @Override
    protected void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(titleFormLbl));
    }

    /**
     * Sets the Assigned To.
     *
     * @param username sets the "Assigned to" value.
     */
    public void setAssignedToUser(final String username) {
        final String locatorBySelect = "[title = \"nameTitle\"]";
        DriverMethods.selectCmb(closeLnk, driver, locatorBySelect, username);
    }

    /**
     * Sets the Subject.
     *
     * @param subject sets the "Subject" value.
     */
    public void setSubject(final String subject) {
        DriverMethod.setTxt(subjectTxt, subject);
    }

    /**
     * Sets the Name.
     *
     * @param nameContact sets the "Name" value.
     */
    public void setNameContact(final String nameContact) {
        final String locatorBySelect = "[title = \"nameTitle\"]";
        DriverMethods.selectCmb(contactCmbbx, driver, locatorBySelect, nameContact);
    }

    /**
     * Sets the Related To.
     *
     * @param nameAccount sets the "Related To" value.
     */
    public void setRelatedToAccount(final String nameAccount) {
        final String locatorBySelect = "[title = \"nameTitle\"]";
        DriverMethods.selectCmb(accountCmbbx, driver, locatorBySelect, nameAccount);
    }

    /**
     * Sets the Location.
     *
     * @param location sets the "Location" value.
     */
    public void setLocation(final String location) {
        DriverMethods.setTxt(locationTxt, location);
    }

    /**
     * Sets the Description.
     *
     * @param description sets the "Description" value.
     */
    public void setDescription(final String description) {
        DriverMethods.setTxt(descriptionTxtar, description);
    }

    /**
     * Creates a new event.
     *
     * @param event     by create a new event.
     * @param keysEvent by references the values.
     */
    @Override
    public void createEvent(final Event event, final Set<String> keysEvent) {
        final HashMap<String, StrategySetter> strategyMap = composesStrategyMap(event);
        keysEvent.forEach(key -> {
            strategyMap.get(key).executeMethod();
            System.out.println("Event UI: " + key);
        });
    }

    /**
     * Return an Strategy Map with the "newEvent" parameter.
     *
     * @param event is an instance Event.
     * @return an instance HashMap with keys and methods to run.
     */
    private HashMap<String, StrategySetter> composesStrategyMap(final Event event) {
        final HashMap<String, StrategySetter> strategyMap = new HashMap<>();
        strategyMap.put("Assigned To", () -> setAssignedToUser(event.getAssignedToUser()));
        strategyMap.put("Subject", () -> setSubject(event.getSubject()));
        strategyMap.put("Name", () -> setNameContact(event.getNameContact()));
        strategyMap.put("Related To", () -> setRelatedToAccount(event.getRelatedToAccount()));
        strategyMap.put("Location", () -> setLocation(event.getLocation()));
        strategyMap.put("Start Date", () -> setStartDate(event.getStartDate()));
        strategyMap.put("End Date", () -> setEndDate(event.getEndDate()));
        strategyMap.put("Description", () -> setDescription(event.getDescription()));
        return strategyMap;
    }

    /**
     * Sets the Star date and Time.
     *
     * @param eventStartDate by gets the date and time.
     */
    private void setStartDate(final Date eventStartDate) {
        final String pattern = "dd-MM-yyyy";
        DriverMethods.setTxt(startDateTxt, DriverMethods.convertDateToString(eventStartDate, pattern));
        setInputFieldJavaScript(startTimeTxt, DateMethods.getHourBefore(eventStartDate, 12));
    }

    /**
     * Sets the End Date and Time.
     *
     * @param eventEndDate by gets the date and time.
     */
    private void setEndDate(final Date eventEndDate) {
        final String pattern = "dd-MM-yyyy";
        DriverMethods.setTxt(endDateTxt, DriverMethods.convertDateToString(eventEndDate, pattern));
        setInputFieldJavaScript(endTimeTxt, DateMethods.getHourBefore(eventEndDate, 14));
    }


    /**
     * Cleans the text box and set new value using javascript.
     *
     * @param element - element to set text.
     * @param text    - Value to fill in input.
     */
    public void setInputFieldJavaScript(final WebElement element, final String text) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].value = ''", element);
        ((JavascriptExecutor) driver).executeScript("arguments[0].value = arguments[1]", element, text);
    }

    /**
     * Gets the event form.
     *
     * @return a instance from EventForm class.
     */
    @Override
    public EventForm getEventForm() {
        return new EventLightningForm();
    }
}
