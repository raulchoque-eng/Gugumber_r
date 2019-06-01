/*
 * @(#) ReaderApplicationProperties.java Copyright (c) 2019 Jala Foundation.
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

package org.fjala.gugumber.salesforce.common;

import org.fjala.gugumber.core.selenium.utils.LoaderProperties;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * ReaderApplicationProperties class.
 *
 * @author Areliez Vargas
 * @version 0.0.1
 */
public class ReaderApplicationProperties {
    /**
     * Constant for path of application properties.
     */
    private static final String SALESFORCE_PROPERTIES = "salesforce.properties";
    /**
     * Map to save the properties of the application.
     */
    private Map<String, String> applicationProperties;

    /**
     * Create a new reader with the properties of the application.
     */
    protected ReaderApplicationProperties() {
        applicationProperties = new HashMap<>();
        addSalesForceProperties();
    }

    /**
     * Returns a new instance of ReaderApplicationProperties.
     *
     * @return a ReaderApplicationProperties.
     */
    public static ReaderApplicationProperties getInstance() {
        return new ReaderApplicationProperties();
    }

    /**
     * Returns the properties of the application.
     *
     * @return a map of properties.
     */
    public Map<String, String> getAppProperties() {

        return applicationProperties;
    }

    /**
     * Adds properties for the Salesforce to map applicationProperties.
     */
    private void addSalesForceProperties() {
        Properties propertiesSalesForce = LoaderProperties.getInstance().readFile(SALESFORCE_PROPERTIES);
        propertiesSalesForce.forEach((key, value) -> applicationProperties.put(key.toString(), value.toString()));
    }
}
