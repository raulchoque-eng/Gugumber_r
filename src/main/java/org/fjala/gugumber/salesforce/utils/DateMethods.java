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

import org.fjala.gugumber.core.selenium.utils.DriverMethods;

import java.util.Date;

/**
 * DateMethods class.
 *
 * @author Raul Choque
 * @version 0.0.1
 */
public class DateMethods {

    /**
     * Returns the hour with a format as a string.
     *
     * @param date    is the information by get a time.
     * @param addHour is information by add hours.
     * @return a hour with a format as a string..
     */
    public static String getHourBefore(final Date date, int addHour) {
        String resTime = "";
        final String HOUR = "h:mm a";
        String time = DriverMethods.convertDateToString(date, HOUR);
        String[] dateHour = (time).split(":");
        String[] minAndBeforeAfterMidday = dateHour[1].split(" ");
        int hour = Integer.parseInt(dateHour[0]);
        int maxHour = 12 - addHour;
        if ((1 <= hour) && (hour <= maxHour)) {
            int nextHour = hour + addHour;
            resTime = Integer.toString(nextHour).concat(":00 " + minAndBeforeAfterMidday[1]);
        } else {
            int restHour = hour - maxHour;
            if ((minAndBeforeAfterMidday[1].compareTo("AM")) == 0) {

                resTime = Integer.toString(restHour) + ":00 PM";
            } else {
                resTime = Integer.toString(restHour) + ":00 AM";
            }
        }
        return resTime;
    }
}
