/*
 * @(#) BrowserConfig.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of Jala
 * Foundation, Inc. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */

package org.fjala.gugumber.core.selenium.webdrivers;

import org.fjala.gugumber.core.selenium.common.ReaderDriverProperties;

/**
 * BrowserConfig class.
 *
 * @author Cxrisstian
 * @version 0.0.1
 */
public class BrowserConfig {

    /**
     * Instances browser Config.
     *
     * @return browserConfig.
     */
    public static BrowserConfig getInstance() {
        return new BrowserConfig();
    }

    /**
     * Gets the browser in which the tests are being executed.
     *
     * @return browser.
     */
    public String getBrowserName() {
        return ReaderDriverProperties.getInstance().getDriverProperties().get("browser");
    }
}
