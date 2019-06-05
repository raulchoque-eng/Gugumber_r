/*
 * @(#) EventFormAbstract.java Copyright (c) 2019 Jala Foundation.
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

import org.fjala.gugumber.salesforce.entities.Event;
import org.fjala.gugumber.salesforce.ui.pages.BasePage;

import java.util.Set;

/**
 * EventFormAbstract class
 *
 * @author Raúl Choque
 * @version 0.0.1
 */
public abstract class EventFormAbstract extends BasePage {

    /**
     * Creates a new Event with the information of event.
     *
     * @param event    is a event to get the information.
     * @param keyEvent is a set of key of references.
     */
    public abstract void createEvent(Event event, Set<String> keyEvent);

//    /**
//     * Gets an EventFormAbstract instance.
//     * Implements this method in its sub-classes.
//     *
//     * @return an instance HomePage.
//     */
//    public abstract EventFormAbstract getEventForm();
}
