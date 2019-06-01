/*
 * @(#) WebDriveFactory.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of Jala
 * Foundation, Inc. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */

package org.fjala.gugumber.salesforce.entities;

/**
 * Context class.
 *
 * @author Cxrisstian
 * @version 0.0.1
 */
public class Context {

    /**
     * Contact of type contact.
     */
    private Contact contact;

    /**
     * Saves value of variable "event", to create an Event.
     */
    private Event event;

    /**
     * Saves value of variable "account", to create an Account.
     * Account to manage in the context.
     */
    private Account account;

    /**
     * Saves value of variable "user", to create an User.
     */
    private User user;

    /**
     * Context for creation of the constructor.
     */
    public Context() {
        this.contact = new Contact();
        this.event   = new Event();
        this.account = new Account();
        this.user    = new User();
    }

    /**
     * Returns the contact of context.
     *
     * @return contact.
     */
    public Contact getContact() {
        return contact;
    }


    /**
     * Returns the account of context.
     *
     * @return an account.
     */
    public Account getAccount() {
        return account;
    }

    /**
     * Gets the instance assigned to "event" variable.
     *
     * @return an instance Event, this is "event" variable.
     */
    public Event getEvent() {
        return event;
    }

    /**
     * Gets the instance assigned to "user" variable.
     *
     * @return an instance Event, this is "user" variable.
     */
    public User getUser() {
        return user;
    }
}
