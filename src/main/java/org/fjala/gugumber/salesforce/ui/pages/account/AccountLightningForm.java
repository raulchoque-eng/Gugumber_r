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
 * AccountLightningForm class.
 *
 * @author Areliez Vargas
 * @version 0.0.1
 */
public class AccountLightningForm extends AccountForm {

    /**
     * Web element for the body of the form.
     */
    @FindBy(css = "div[class='modal-body scrollable slds-modal__content slds-p-around--medium']")
    private WebElement formModalBody;

    /**
     * Web element for the text-box the account name.
     */
    @FindBy(xpath = "//input[@id=//label[contains(.,'Account') and starts-with(.,'Account Name')]/@for]")
    private WebElement accountNameTxtB;

    /**
     * Web element for the button save of the footer in the form.
     */
    @FindBy(css = "[data-aura-class='uiButton--default uiButton--brand uiButton forceActionButton']")
    //@FindBy(css = "[title='Save']")
    private WebElement saveBtn;

    /**
     * Waits until page object is loaded.
     */
    @Override
    protected void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(formModalBody));
    }

    /**
     * Sets the name account on the text-box the form.
     *
     * @param accountName to set the account name.
     */
    @Override
    public void setNameAccountOnTxtB(final String accountName) {
        accountNameTxtB.sendKeys(accountName);
    }

    /**
     * Returns a new profile account for the layout lightning page.
     *
     * @return a profile account lightning.
     */
    @Override
    public AccountProfilePage clickOnSaveBtnFoot() {
        saveBtn.click();
        return new AccountProfileLightningPage();
    }
}
