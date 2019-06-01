/*
 * @(#) Event.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av. Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of Jala
 * Foundation, Inc. ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */

package org.fjala.gugumber.salesforce.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.fjala.gugumber.core.StrategySetter;

/**
 * Event class
 *
 * @author Raúl Choque
 * @version 0.0.1
 */
public class Event implements Component {

    /**
     * Saves value of variable "Assigned To", to create an Event.
     */
    private String assignedToUser;

    /**
     * Saves value of variable "Subject", to create an Event.
     */
    private String subject;

    /**
     * Saves value of variable "Name", to create an Event.
     */
    private String nameContact;

    /**
     * Saves value of variable "Related To", to create an Event.
     */
    private String relatedToAccount;

    /**
     * Saves value of variable "Location", to create an Event.
     */
    private String location;

    /**
     * Saves value of variable "Start Date", to create an Event.
     */
    private Date startDate;

    /**
     * Saves value of variable "Start Time", to create an Event.
     */
    private String startTime;

    /**
     * Saves value of variable "End Date", to create an Event.
     */
    private Date endDate;

    /**
     * Saves value of variable "End Time", to create an Event.
     */
    private String endTime;

    /**
     * Saves value of variable "Description", to create an Event.
     */
    private String description;

    /**
     * Gets the value assigned to "assignedTo" variable.
     *
     * @return a string, this is "assignedTo" variable.
     */
    public String getAssignedToUser() {
        return assignedToUser;
    }

    /**
     * Sets the value "assignedTo" variable.
     */
    public void setAssignedToUser(final String assignedToUser) {
        this.assignedToUser = assignedToUser;
    }

    /**
     * Gets the value assigned to "subject" variable.
     *
     * @return a string, this is "Subject" variable.
     */
    public String getSubject() {
        return subject;
    }

    /**
     * Sets the value "subject" variable.
     */
    public void setSubject(final String subject) {
        this.subject = subject;
    }

    /**
     * Gets the value assigned to "nameContact" variable.
     *
     * @return a string, this is "nameContact" variable.
     */
    public String getNameContact() {
        return nameContact;
    }

    /**
     * Sets the value "nameContact" variable.
     */
    public void setNameContact(final String nameContact) {
        this.nameContact = nameContact;
    }

    /**
     * Gets the value assigned to "relatedToAccount" variable.
     *
     * @return a string, this is "relatedToAccount" variable.
     */
    public String getRelatedToAccount() {
        return relatedToAccount;
    }

    /**
     * Sets the value "relatedToAccount" variable.
     */
    public void setRelatedToAccount(final String relatedToAccount) {
        this.relatedToAccount = relatedToAccount;
    }

    /**
     * Gets the value assigned to "location" variable.
     *
     * @return a string, this is "location" variable.
     */
    public String getLocation() {
        return location;
    }

    /**
     * Sets the value "location" variable.
     */
    public void setLocation(final String location) {
        this.location = location;
    }

    /**
     * Gets the value assigned to "startDate" variable.
     *
     * @return a string, this is "startDate" variable.
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * Sets the value "startDate" variable.
     */
    public void setStartDate(final String startDate) {
        if (startDate.equals("One hour from now")) {
            this.startDate = new Date();
        }
    }

    /**
     * Gets the value assigned to "startTime" variable.
     *
     * @return a string, this is "startTime" variable.
     */
    public String getStartTime() {
        return startTime;
    }

    /**
     * Sets the value "startTime" variable.
     */
    public void setStartTime(final String startTime) {
        this.startTime = startTime;
    }

    /**
     * Gets the value assigned to "EndDate" variable.
     *
     * @return a string, this is "EndDate" variable.
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * Sets the value "endDate" variable.
     */
    public void setEndDate(final String endDate) {
        if (endDate.equals("Two hours from now")) {
            this.endDate = new Date();
        }
    }

    /**
     * Gets the value assigned to "EndTime" variable.
     *
     * @return a string, this is "EndTime" variable.
     */
    public String getEndTime() {
        return endTime;
    }

    /**
     * Sets the value "endTime" variable.
     */
    public void setEndTime(final String endTime) {
        this.endTime = endTime;
    }

    /**
     * Gets the value assigned to "description" variable.
     *
     * @return a string, this is "description" variable.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value "description" variable.
     */
    public void setDescription(final String description) {
        this.description = description;
    }

    /**
     * Sets all values send into the "newEvent" parameter.
     *
     * @param newEvent is an Event into Map.
     */
    public void setDataToEvent(final Map<String, String> newEvent) {
        final HashMap<String, StrategySetter> strategyMap = composeStrategyMap(newEvent);
        newEvent.keySet().forEach(key -> {
            strategyMap.get(key).executeMethod();
            System.out.println("Event object: " + key);
        });
    }

    /**
     * Composes an Strategy Map with the "newEvent" parameter.
     *
     * @param newEvent is an Event into Map.
     * @return an instance HashMap with keys and methods to run.
     */
    private HashMap<String, StrategySetter> composeStrategyMap(final Map<String, String> newEvent) {
        final HashMap<String, StrategySetter> strategyHashMap = new HashMap<>();
        strategyHashMap.put("Assigned To", () -> setAssignedToUser(newEvent.get("Assigned To")));
        strategyHashMap.put("Subject", () -> setSubject(newEvent.get("Subject")));
        strategyHashMap.put("Name", () -> setNameContact(newEvent.get("Name")));
        strategyHashMap.put("Related To", () -> setRelatedToAccount(newEvent.get("Related To")));
        strategyHashMap.put("Location", () -> setLocation(newEvent.get("Location")));
        strategyHashMap.put("Start Date", () -> setStartDate(newEvent.get("Start Date")));
//        strategyHashMap.put("Start Time", () -> setStartTime(newEvent.get("Start Time")));
        strategyHashMap.put("End Date", () -> setEndDate(newEvent.get("End Date")));
//        strategyHashMap.put("End Time", () -> setEndTime(newEvent.get("End Time")));
        strategyHashMap.put("Description", () -> setDescription(newEvent.get("Description")));

        return strategyHashMap;
    }

    /**
     * Converts an instance Event to Map build.
     *
     * @return Map build from Event.
     */
    @Override
    public Map<String, String> toMap() {
        final Map<String, String> eventToMap = new HashMap<>();
        eventToMap.put("Subject", getSubject());
        eventToMap.put("StartDateTime", changeToStringDate(getStartDate()));
        eventToMap.put("EndDateTime", changeToStringDate(getEndDate()));
        return eventToMap;
    }

    /**
     * Changes to string a date with a personalize format.
     *
     * @param date change format to string.
     * @return an string  from date parameter.
     */
    public String changeToStringDate(final Date date) {
        final String restDate;
        final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        final SimpleDateFormat dateTime = new SimpleDateFormat("hh:mm:ss");
        restDate = dateFormat.format(date) + "T" + dateTime.format(date) + ".000+0000";
        return restDate;
    }
}
