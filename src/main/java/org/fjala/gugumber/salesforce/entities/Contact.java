/*
 * @(#) Contact.java Copyright (c) 2019 Jala Foundation.
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

/**
 * Contact class.
 *
 * @author Raul Choque
 * @version 0.0.1
 */
public class Contact {

    /**
     * Saves value of variable "firstName", to create an User.
     */
    private String firstName;

    /**
     * Saves value of variable "lastName", to create an User
     */
    private String lastName;

    /**
     * Gets the value assigned to "firstName" variable.
     *
     * @return a string, this is "firstName" variable.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the value "firstName" variable.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the value assigned to "lastName" variable.
     *
     * @return a string, this is "lastName" variable.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the value "setLastName" variable.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
