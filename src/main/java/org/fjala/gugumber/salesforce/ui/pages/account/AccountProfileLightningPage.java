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

package org.fjala.gugumber.salesforce.ui.pages.account;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * AccountProfileLightningPage class.
 *
 * @author Areliez Vargas
 * @version 0.0.1
 */
public class AccountProfileLightningPage extends AccountProfilePage {

    /**
     * Web element for the body of profile account.
     */
    @FindBy(css = "div[class='flexipagePage oneRecordHomeFlexipage']")
    private WebElement accountProfile;

    /**
     * Web element for the account name of the profile header.
     */
    @FindBy(css = "span[class='custom-truncate uiOutputText']")
    private WebElement accountTitle;

    /**
     * Waits until page object is loaded.
     */
    @Override
    protected void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(accountProfile));
    }

    /**
     * Return the text of name account from the profile header.
     *
     * @return the name account as string.
     */
    @Override
    public String getNameAccountFromProfileHeader() {
        return accountTitle.getText();
    }
}
