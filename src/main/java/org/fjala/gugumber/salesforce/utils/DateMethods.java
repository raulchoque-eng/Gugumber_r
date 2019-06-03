/*
 * @(#) DateMethods.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av. Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of Jala
 * Foundation, Inc. ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */

package org.fjala.gugumber.salesforce.utils;

import org.fjala.gugumber.core.selenium.utils.DriverMethod;

import java.util.Date;

/**
 * DateMethods class.
 *
 * @author Raul Choque
 * @version 0.0.1
 */
public class DateMethods {
    public static String getNextOneHour(final Date date) {
        String resTime = "";
        final String HOUR = "h:mm a";
        String time = DriverMethod.convertDateToString(date, HOUR);
        String[] dateHour = (time).split(":");
        String[] minAndBeforeAfterMidday = dateHour[1].split(" ");
        int hour = Integer.parseInt(dateHour[0]);
        if ((1 <= hour) && (hour <= 11)) {
            int nextHour = hour + 1;
            resTime = Integer.toString(nextHour).concat(":00 " + minAndBeforeAfterMidday[1]);
        } else {
            if ((minAndBeforeAfterMidday[1].compareTo("AM")) == 0) {
                resTime = "1:00 PM";
            } else {
                resTime = "1:00 AM";
            }
        }

        return resTime;

    }

    public static String getNextTwoHours(final Date date) {

        String resTime = "";
        final String HOUR = "h:mm a";
        String time = DriverMethod.convertDateToString(date, HOUR);
        String[] dateHour = (time).split(":");
        String[] minAndBeforeAfterMidday = dateHour[1].split(" ");
        int hour = Integer.parseInt(dateHour[0]);
        if ((1 <= hour) && (hour <= 10)) {
            int nextHour = hour + 2;
            resTime = Integer.toString(nextHour).concat(":00 " + minAndBeforeAfterMidday[1]);
        } else {
            if ((minAndBeforeAfterMidday[1].compareTo("AM")) == 0) {
                resTime = "1:00 PM";
            } else {
                resTime = "1:00 AM";
            }
        }

        return resTime;
    }

}
