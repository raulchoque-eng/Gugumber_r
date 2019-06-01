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

package org.fjala.gugumber.salesforce.ui.pages.components;

import org.fjala.gugumber.salesforce.ui.pages.account.AccountsClassicPage;
import org.fjala.gugumber.salesforce.ui.pages.account.AccountsPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * NavBarClassic class.
 *
 * @author Areliez Vargas
 * @version 0.0.1
 */
public class NavBarClassic extends NavBar {

    /**
     * Web element of tab-bar of navigation bar.
     */
    @FindBy(id = "tabBar")
    private WebElement tabBar;

    /**
     * Web element for the account option.
     */
    @FindBy(xpath = "//li[@id='Account_Tab']//a")
    private WebElement accountOption;

    /**
     * Waits until page object is loaded.
     */
    @Override
    protected void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(tabBar));
    }

    /**
     * Returns the account classic page after clicking on account option.
     *
     * @return a account classic page.
     */

    @Override
    public AccountsPage clickAccountsOption() {
        accountOption.click();
        return new AccountsClassicPage();
    }
//    @Override
//    public ContactPageAbstract goToContactPage() {
//        return null;
//    }

}
