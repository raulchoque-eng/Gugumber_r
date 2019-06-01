/*
 * @(#) Logs.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of Jala
 * Foundation, Inc. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 *
 */

package org.fjala.gugumber.core.selenium.utils;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * Logs class.
 *
 * @author Areliez Vargas
 * @version 0.0.1
 */
public class Logs {

    /**
     * Constant for the path of log properties.
     */
    private static final String LOG_4_J_PROPERTIES = "../Gugumber/log4j.properties";
    /**
     * Initializes instance of log as null.
     */
    private static Logs instance = null;
    /**
     * Constant for logger.
     */
    private final static Logger LOGGER = Logger.getLogger(Logs.class);

    /**
     * Constructor private for Singleton class.
     */
    private Logs() {
        super();
    }

    /**
     * Returns a instance of a log.
     *
     * @return a instance.
     */
    public static Logs getInstance() {
        if (instance == null) {
            instance = new Logs();
            PropertyConfigurator.configure(LOG_4_J_PROPERTIES);
            LOGGER.setLevel(Level.ALL);
        }
        return instance;
    }

    /**
     * Returns logger to add loggers.
     * @return a LOGGER.
     */
    public Logger getLog() {
        return LOGGER;
    }
}
