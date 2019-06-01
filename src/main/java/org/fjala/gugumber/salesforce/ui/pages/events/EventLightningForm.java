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

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;

import org.fjala.gugumber.core.StrategySetter;
import org.fjala.gugumber.core.selenium.utils.DriverMethods;
import org.fjala.gugumber.salesforce.entities.Event;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * EventLightningForm class.
 *
 * @author Raul Choque
 * @version 0.0.1
 */
public class EventLightningForm extends EventForm {


    @FindBy(css = "div.modal-header h2.title")
    WebElement titleFormLbl;

    @FindBy(css = "div.modal-container slds-modal__container")
    WebElement eventForm;

    @FindBy(xpath = "//input[starts-with(@id, 'input')]")
    WebElement sunjectTxtb;

    @FindBy(css = "div.uiInput a.deleteAction")
    WebElement closeLnk;

    @FindBy(css = "div.slds-form input[title = \"Search People\"]")
    WebElement searchPeopleTxtb;

    @FindBy(css = "div.modal-body input[id ^= \"input\"]")
    WebElement subjectCmbbx;

    @FindBy(css = "div.modal-body div div[role = \"none\"] ~div")
    private WebElement subjectSelectCmbbx;

    @FindBy(css = "div.modal-body input[title = \"Search Contacts\"]")
    WebElement contactCmbbx;

    @FindBy(css = "div.modal-body input[title = \"Search Accounts\"]")
    WebElement accountCmbbx;

    @FindBy(css = "div.modal-body div.uiInputText input.input")
    WebElement locationTxt;

    @FindBy(css = "div.modal-body div.slds-grid.slds-gutters_small:nth-of-type(2) div.dateTime-inputDate input")
    WebElement startDateTxt;

    @FindBy(css = "div.modal-body div.slds-grid.slds-gutters_small:nth-of-type(2) div.dateTime-inputTime input")
    WebElement startTimeTxt;

    @FindBy(css = "div.modal-body div.slds-grid.slds-gutters_small:nth-of-type(3) div.dateTime-inputDate input")
    WebElement endDateTxt;

    @FindBy(css = "div.modal-body div.slds-grid.slds-gutters_small:nth-of-type(3) div.dateTime-inputTime input")
    WebElement endTimeTxt;

    @FindBy(css = "div.modal-body input[type = \"checkbox\"]")
    WebElement allDaysCbox;

    @FindBy(css = "span#quickTextKeyboardTip ~ textarea")
    WebElement descriptionTxtar;

    @FindBy(css = "div.modal-footer button[title=\"Save\"]")
    WebElement saveBtn;

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(titleFormLbl));
    }

    /**
     * @param username sets the "Assigned to" value.
     */
    public void setAssignedToUser(final String username) {
        final String locatorBySelect = "[title = \"nameTitle\"]";
        DriverMethods.selectCmb(closeLnk, driver, locatorBySelect, username);
    }

    /**
     * @param subject sets the "Subject" value.
     */
    public void setSubject(final String subject) {
        subjectCmbbx.sendKeys(subject);
    }

    /**
     * @param nameContact sets the "Name" value.
     */
    public void setNameContact(final String nameContact) {
        final String locatorBySelect = "[title = \"nameTitle\"]";
        DriverMethods.selectCmb(contactCmbbx, driver, locatorBySelect, nameContact);
    }

    /**
     * @param nameAccount sets the "Related To" value.
     */
    public void setRelatedToAccount(final String nameAccount) {
        final String locatorBySelect = "[title = \"nameTitle\"]";
        DriverMethods.selectCmb(accountCmbbx, driver, locatorBySelect, nameAccount);
    }

    /**
     * @param location sets the "Location" value.
     */
    public void setLocation(final String location) {
        DriverMethods.setTxt(locationTxt, location);
    }

    /**
     * @param description sets the "Description" value.
     */
    public void setDescription(final  String description) {
        DriverMethods.setTxt(descriptionTxtar, description);
    }

    @Override
    public void createEvent(final Event event,final Set<String> keysEvent) {
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

    private void setStartDate(final Date eventStartDate) {

        Date test1 = new Date();
        System.out.println("Start Calendar: " + Calendar.getInstance() + "; " + "Start Date: " + test1);
        final String pattern = "M/dd/yyyy";
        final String HOUR = "h:mm a";
        DriverMethods.setTxt(startDateTxt, DriverMethods.convertDateToString(eventStartDate, pattern));
        DriverMethods.setTxt(startTimeTxt, DriverMethods.convertDateToString(eventStartDate, HOUR));
    }

    private void setEndDate(final Date eventEndDate) {
        final String pattern = "M/dd/yyyy";
        final String HOUR = "h:mm a";
        DriverMethods.setTxt(endDateTxt, DriverMethods.convertDateToString(eventEndDate, pattern));
        DriverMethods.setTxt(endTimeTxt, DriverMethods.convertDateToString(eventEndDate, HOUR));
    }

    @Override
    public EventForm getEventForm() {
        return new EventLightningForm();
    }
}
