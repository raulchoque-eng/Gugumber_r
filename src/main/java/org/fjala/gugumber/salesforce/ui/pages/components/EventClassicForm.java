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

package org.fjala.gugumber.salesforce.ui.pages.classic;

import java.util.Set;

import org.fjala.gugumber.salesforce.entities.Event;
import org.fjala.gugumber.salesforce.ui.pages.events.EventForm;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * EventClassicForm class.
 *
 * @author Raul Choque
 * @version 0.0.1
 */
public class EventClassicForm extends EventForm {

    @FindBy(id = "ep")
    WebElement eventForm;

    @Override
    public void createEvent(final Event event,final Set<String> keyEvent) {

    }

    @Override
    public EventForm getEventForm() {
        return new EventClassicForm();
    }

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(eventForm));
    }
}
