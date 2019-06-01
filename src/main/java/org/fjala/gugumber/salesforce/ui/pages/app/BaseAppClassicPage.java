/*
 * @(#) GeneratorReport.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av. Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 *  All rights reserved.
 *
 * This software is the confidential and proprietary information of Jala
 * Foundation, Inc. ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 *  with Jala Foundation.
 */

package org.fjala.gugumber.salesforce.ui.pages.app;

import org.fjala.gugumber.salesforce.ui.pages.components.NavBar;
import org.fjala.gugumber.salesforce.ui.pages.components.NavBarClassic;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * BaseAppClassicPage class.
 *
 * @author Cristian Lujan
 * @version 0.0.1
 */
public class BaseAppClassicPage extends BaseAppPage {

    /**
     * Locator for header of base page.
     */
    @FindBy(id = "AppBodyHeader")
    private WebElement basePageHeader;

    /**
     * Waits until page object is loaded.
     */
    @Override
    protected void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(basePageHeader));
    }

    /**
     * Gets for navBar.
     * @return new navBar Classic.
     */
    @Override
    public NavBar getNavBar() {
        return new NavBarClassic();
    }
}
