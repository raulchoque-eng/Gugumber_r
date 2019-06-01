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

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * AccountsLightningPage class.
 *
 * @author Areliez Vargas
 * @version 0.0.1
 */
public class AccountsLightningPage extends AccountsPage {

    /**
     * Web element to the header the accounts page.
     */
    @FindBy(xpath = "//div[@data-aura-class='forceListViewManagerHeader']")
    private WebElement accountsHeaderPage;

    /**
     * Web element for the button new of accounts page.
     */
    @FindBy(xpath = "//a[@title='New']")
    private WebElement newAccoutnBtn;

    /**
     * List of web elements for accounts name.
     */
    @FindBy(css = "a[data-aura-class='forceOutputLookup']")
    private List<WebElement> AccountsNameList;

    /**
     * Waits until page object is loaded.
     */
    @Override
    protected void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(accountsHeaderPage));
    }

    /**
     * return a new account form for the layout lightning after clicking on new button.
     *
     * @return a account lightning form.
     */
    @Override
    public AccountForm clickNewBtn() {
        newAccoutnBtn.click();
        return new AccountLightningForm();
    }

    /**
     * Returns a list with the account name from accounts page.
     * @return a list with accounts names as string.
     */
    @Override
    public List<String> getListOfAccountsName() {
        final List<String> accountsName = new ArrayList<>();
        for (WebElement accountName : AccountsNameList) {
            accountsName.add(accountName.getText());
        }
        return accountsName;
    }
}
