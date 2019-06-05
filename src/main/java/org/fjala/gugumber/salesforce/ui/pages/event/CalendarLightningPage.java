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

package org.fjala.gugumber.salesforce.ui.pages.event;

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

    /**
     * Web element by the calendar header.
     */
    @FindBy(css = "div.calendarHeader")
    private WebElement calendarHeader;

    /**
     * Web element by open the  event form.
     */
    @FindBy(css = "button.new-event-button")
    private WebElement newEventBtn;


    /**
     * Waits until the calendar page is loaded.
     */
    @Override
    protected void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(calendarHeader));
    }

    /**
     * Opens EventFormAbstract from Calendar page.
     *
     * @return an instance EventFormAbstract.
     */
    public EventFormAbstract openEventForm() {
        newEventBtn.click();
        return new EventLightningForm();
    }
}
