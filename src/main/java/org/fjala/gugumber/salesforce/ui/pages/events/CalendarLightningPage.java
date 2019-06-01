/*
 * @(#) CalendarLightningPage.java Copyright (c) 2019 Jala Foundation.
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

import org.fjala.gugumber.salesforce.ui.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * CalendarLightningPage class.
 *
 * @author Raul Choque
 * @version 0.0.1
 */
public class CalendarLightningPage extends BasePage {

    @FindBy(css = "div.calendarHeader")
    WebElement calendarHeader;

    @FindBy(css = "button.new-event-button")
    WebElement newEventBtn;

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(calendarHeader));
    }

    /**
     * Opens EventForm from Calendar page.
     *
     * @return an instance EventForm.
     */
    public EventForm openEventForm() {
        newEventBtn.click();
        return new EventLightningForm();
    }
}
