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
 * AccountsClassicPage class.
 *
 * @author Areliez Vargas
 * @version 0.0.1
 */
public class AccountsClassicPage extends AccountsPage {

    /**
     * Web element for the body of the account page.
     */
    @FindBy(id = "bodyCell")
    private WebElement body;

    /**
     * Web element for the button new.
     */
    @FindBy(css = "input[class='btn'][name='new']")
    private WebElement newAccountBtn;

    @FindBy(css = "th[class=' dataCell  ']")
    private List<WebElement> AccountsNameList;

    /**
     * Waits until page object is loaded.
     */
    @Override
    protected void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(body));
    }

    /**
     * Returns a new account form for the layout classic after clicking on new button.
     *
     * @return a new account classic form.
     */
    @Override
    public AccountForm clickNewBtn() {
        newAccountBtn.click();
        return new AccountClassicForm();
    }

    /**
     * Returns a list of name accounts from the accounts page.
     *
     * @return a list with the name accounts.
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
