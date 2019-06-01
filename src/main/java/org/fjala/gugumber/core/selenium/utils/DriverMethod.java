/*
 * @(#) DriverMethod.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av. Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of Jala
 * Foundation, Inc. ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */

package org.fjala.gugumber.core.selenium.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * DriverMethod class.
 *
 * @author Raul Choque
 * @version 0.0.1
 */
public class DriverMethod {

    /**
     * Sets the text into the webElement.
     *
     * @param webElement that sets its text.
     * @param text       new value of webElement.
     */
    public static void setTxt(final WebElement webElement, final String text) {
        webElement.clear();
        webElement.sendKeys(text);
    }

    /**
     * Sets the comboBox into the webElement.
     *
     * @param webElement that sets its comboBox.
     * @param driver     that connection for web elements.
     * @param replaceCmb value for replace.
     * @param text       new value of webElement.
     */
    public static void selectCmb(final WebElement webElement, final WebDriver driver, final String replaceCmb, final String text) {
        webElement.click();
        driver.findElement(By.cssSelector(replaceCmb.replace("nameTitle", text))).click();
    }

    /**
     * Converts a date to string applying a pattern.
     *
     * @param date    changes of type to convert in a string, applying "pattern" variable
     * @param pattern is format that assign to "date" parameter.
     * @return an string build from a "date" parameter.
     */
    public static String convertDateToString(final Date date, final String pattern) {
        // Create an instance of SimpleDateFormat used for formatting
        // the string representation of date according to the chosen pattern
        final DateFormat dateFormat = new SimpleDateFormat(pattern);
        return dateFormat.format(date);
    }

    /**
     * TODO method to clear a checkbox
     * TODO method que valida que un elemento este en el DOM cambiando el implicit wait (1)
     * TODO validate method that a webElement is in the DOM change the implicit wait (1)
     */
}
