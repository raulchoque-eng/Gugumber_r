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

import org.fjala.gugumber.salesforce.ui.pages.BasePage;

/**
 * AccountForm abstract class.
 *
 * @author Areliez Vargas
 * @version 0.0.1
 */
public abstract class AccountForm extends BasePage {

    /**
     * Enters a name of account in the form.
     *
     * @param accountName to set the account name.
     */
    public abstract void setNameAccountOnTxtB(String accountName);

    /**
     * Returns an Account Profile page after clicking on save button of the footer.
     *
     * @return an account profile page.
     */
    public abstract AccountProfilePage clickOnSaveBtnFoot();
}
