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
 * AccountClassicForm class.
 *
 * @author Areliez Vargas
 * @version 0.0.1
 */
public class AccountClassicForm extends AccountForm {

    /**
     * Web element for the body form of account.
     */
    @FindBy(css = "td[id=bodyCell]")
    private WebElement form;

    /**
     * Web element for the text=box of account name.
     */
    @FindBy(xpath = "//div[@class='requiredInput']//input")
    private WebElement accountNameTxtB;

    /**
     * Web element for the button save of footer.
     */
    @FindBy(css = "td[id='bottomButtonRow'] input[name='save']")
    private WebElement saveBtnfoot;

    /**
     * Waits until page object is loaded.
     */
    @Override
    protected void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(form));
    }

    /**
     * Enters the name for the account sending a string.
     *
     * @param accountName to set the account name.
     */
    @Override
    public void setNameAccountOnTxtB(final String accountName) {
        accountNameTxtB.sendKeys(accountName);
    }

    /**
     * Returns a new account profile after clicking on save button.
     *
     * @return a new account profile classic page.
     */
    @Override
    public AccountProfilePage clickOnSaveBtnFoot() {
        saveBtnfoot.click();
        return new AccountProfileClassicPage();
    }
}
