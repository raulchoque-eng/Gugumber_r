/*
 * @(#) PageLayoutConfig.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of Jala
 * Foundation, Inc. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */

package org.fjala.gugumber.salesforce.ui;

import org.fjala.gugumber.salesforce.common.ReaderApplicationProperties;

/**
 * PageLayoutConfig class.
 *
 * @author Areliez Vargas
 * @version 0.0.1
 */
public class PageLayoutConfig {

    /**
     * Constant for the key of layout.
     */
    private static final String LAYOUT = "type-layout";

    /**
     * Initializes the page layout config.
     *
     * @return a new PageLayoutConfig.
     */
    public static PageLayoutConfig getInstance() {
        return new PageLayoutConfig();
    }

    /**
     * Gets the name of page layout in which the tests are being executed.
     *
     * @return page layout.
     */
    public static PageLayoutType getPageLayoutName() {
        final String layoutName = ReaderApplicationProperties.getInstance().getAppProperties().get(LAYOUT).toUpperCase();
        return PageLayoutType.valueOf(layoutName);
    }
}
