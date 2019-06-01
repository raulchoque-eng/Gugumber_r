/*
 * @(#) ReaderDriverProperties.java Copyright (c) 2019 Jala Foundation.
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

package org.fjala.gugumber.core.selenium.common;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.fjala.gugumber.core.selenium.utils.LoaderProperties;

/**
 * ReaderDriverProperties class.
 *
 * @author Areliez Vargas
 * @version 0.0.1
 */
public class ReaderDriverProperties {
    /**
     * Constant for path of driver driverProperties.
     */
    private static final String DRIVER_PROPERTIES = "driver.properties";

    /**
     * Map for save driver properties.
     */
    private Map<String, String> driverProperties;

    /**
     * Initializes a new reader with the properties for driver.
     */
    private ReaderDriverProperties() {
        driverProperties = new HashMap<>();
        addPropertiesDriver();
    }

    /**
     * Initializes a new reader for driver properties.
     *
     * @return a ReaderDriverProperties.
     */
    public static ReaderDriverProperties getInstance() {
        return new ReaderDriverProperties();
    }

    /**
     * Gets the properties of map.
     *
     * @return driver properties.
     */
    public Map<String, String> getDriverProperties() {
        return driverProperties;
    }

    /**
     * Adds the properties of driver.properties file to the map.
     */
    private void addPropertiesDriver() {
        Properties driverFileProperties = LoaderProperties.getInstance().readFile(DRIVER_PROPERTIES);
        driverFileProperties.forEach((key, value) -> driverProperties.put(key.toString(), value.toString()));
    }

}
