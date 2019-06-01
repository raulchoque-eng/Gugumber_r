/*
 * @(#) LoaderProperties.java Copyright (c) 2019 Jala Foundation.
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

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * LoaderProperties class.
 *
 * @author Areliez Vargas
 * @version 0.0.1
 */
public class LoaderProperties {

    /**
     * Constructor protected.
     */
    protected LoaderProperties() {
    }

    /**
     * Initialize a new LoaderProperties.
     *
     * @return a LoaderProperties.
     */
    public static LoaderProperties getInstance() {
        return new LoaderProperties();
    }

    /**
     * Loads a property file.
     *
     * @param path of properties.
     * @return the properties.
     */
    public Properties readFile(String path) {
        Properties prop = new Properties();
        try {
            InputStream input = new FileInputStream(path);
            Logs.getInstance().getLog().info("Load a file properties");
            prop.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }
}
