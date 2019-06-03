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
//    @FindBy(css = "div#ep > div.pbBody > div:nth-child(4) > table tr:nth-child(1) td:nth-child(2) span.lookupInput > input")
//    private WebElement assignedUserTxt;

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

    @FindBy(css = "div#ep > div.pbBody > div:nth-child(4) > table tr:nth-child(6) td:nth-child(2) select")
    private WebElement relatedToCmbbx;

    @FindBy(css = "div#ep > div.pbBody > div:nth-child(4) > table tr:nth-child(6) td:nth-child(2) span.lookupInput [title=\"Related To\"]")
    private WebElement getRelatedToTxt;

    /**
     * Web element by the Description.
     */
    @FindBy(css = "td.last.data2Col > textarea")
    private WebElement descriptionTxtar;

    @FindBy(css = "td#topButtonRow [value = \" Save \"]")
    private WebElement saveEventBtn;

    @Override
    public void createEvent(final Event event,final Set<String> keyEvent) {
        setAssignedToUser(event.getAssignedToUser());
        setLocation(event.getLocation());
        setSubject(event.getSubject());
        setNameContact(event.getNameContact());
        setDescription(event.getDescription());
    }

    @Override
    public EventForm getEventForm() {
        return new EventClassicForm();
    }

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(eventForm));
    }

    /**
     * @param username sets the "Assigned to" value.
     */
    public void setAssignedToUser(final String username) {
        searchUserImg.click();
        String parentWindowHandle = driver.getWindowHandle();
        Set<String> windows = driver.getWindowHandles();
        driver.switchTo().window(new LinkedList<>(windows).getLast());
        driver.switchTo().frame("resultsFrame");
        driver.findElement(By.cssSelector("table.list tr:nth-child(2) th:nth-child(1) a")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.switchTo().window(parentWindowHandle);
//        if (parentWindowHandle != null) {
//            driver.switchTo().window(parentWindowHandle);
//        } else {
//            driver.switchTo().defaultContent();
//        }
    }

//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//        System.out.println("second driver: " + driver.getTitle());
//        driver.findElement(By.id("lksrch")).sendKeys(username);


//        // Store the current window handle
//        String winHandleBefore = driver.getWindowHandle();
//        https:
////na132.salesforce.com/00U/e?retURL=%2Fhome%2Fhome.jsp
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//        System.out.println("parent windows =" + winHandleBefore);
//
//        // Perform the click operation that opens new window
//        driver.findElement(By.cssSelector("div#ep > div.pbBody > div:nth-child(4) > table tr:nth-child(1) td:nth-child(2) img.lookupIcon")).click();
//
//        // Switch to new window opened
//        for (String winHandle : driver.getWindowHandles()) {
//            driver.switchTo().window(winHandle);
//            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//        }
//
//        // Perform the actions on new window
////        driver.findElement(By.id("lksrch")).sendKeys("User To Event");
//        System.out.println("child windows = " + driver.getTitle());
//        // Close the new window, if that window no more required
//        driver.close();
//
//        // Switch back to original browser (first window)
//        driver.switchTo().window(winHandleBefore);
//
//        // Continue with original browser (first window)
////         DriverMethod.setTxt(assignedUserTxt, username);


//    /**
//     * Switches to recent window opened.
//     */
//    protected void switchToRecentWindowOpened() {
//        parentWindowHandle = driver.getWindowHandle();
//        Set<String> windows = driver.getWindowHandles();
//        driver.switchTo().window(new LinkedList<>(windows).getLast());
//    }
//    protected void switchToParentWindowHandle() {
//        if (parentWindowHandle != null) {
//            driver.switchTo().window(parentWindowHandle);
//        } else {
//            driver.switchTo().defaultContent();
//        }
//    }

    /**
     * Sets the Location.
     *
     * @param location sets the "Assigned to" value.
     */
    public void setLocation(final String location) {
        DriverMethod.setTxt(locationTxt, location);
    }

    /**
     * Sets the Subject.
     *
     * @param subject sets the "Assigned to" value.
     */
    public void setSubject(final String subject) {
        DriverMethod.setTxt(subjectTxt, subject);
    }

    /**
     * @param startDate sets the "Assigned to" value.
     */
    public void setStarDate(final Date startDate) {
    }

    /**
     * Sets the Name.
     *
     * @param contactName sets the "Assigned to" value.
     */
    public void setNameContact(final String contactName) {

        DriverMethod.setTxt(nameTxt, contactName);
    }

    /**
     * @param endDate sets the "Assigned to" value.
     */
    public void setEndDate(final Date endDate) {
    }

    /**
     * Sets the Description.
     *
     * @param description sets the "Assigned to" value.
     */
    public void setDescription(final String description) {
        DriverMethod.setTxt(descriptionTxtar, description);
    }
}
