/*
 * @(#) AccountSteps.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av. Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of Jala
 * Foundation, Inc. ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */

package org.fjala.gugumber.steps;

import java.util.Map;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fjala.gugumber.salesforce.entities.Context;
import org.fjala.gugumber.salesforce.ui.PageLayoutFactory;
import org.fjala.gugumber.salesforce.ui.pages.account.AccountForm;
import org.fjala.gugumber.salesforce.ui.pages.account.AccountProfilePage;
import org.fjala.gugumber.salesforce.ui.pages.account.AccountsPage;
import org.testng.Assert;

/**
 * AccountSteps class.
 *
 * @author Areliez Vargas
 * @version 0.0.1
 */
public class AccountSteps {

    /**
     * Variable for the account page.
     */
    private AccountsPage accountsPage;

    /**
     * Variable for the account form.
     */
    private AccountForm accountForm;

    /**
     * Variable for the profile account page.
     */
    private AccountProfilePage accountProfilePage;

    /**
     * Variable for the context.
     */
    Context context;

    /**
     * Constructor of account steps sending the context.
     *
     * @param context init the context.
     */
    public AccountSteps(final Context context) {
        this.context = context;
    }

    /**
     * Opens the account form from accounts page.
     */
    @When("^I open the Account form from Accounts page$")
    public void iOpenTheAccountFormFromAccountsPage() {
        accountsPage = PageLayoutFactory.getAccountsPage();
        accountForm = accountsPage.clickNewBtn();
    }

    /**
     * Creates a new account sending the information.
     *
     * @param accountMap for the information of account.
     */
    @When("^I create a new Account with the following information$")
    public void createANewAccountWithTheFollowingInformation(final Map<String,String> accountMap) {
        context.getAccount().setAccountInformation(accountMap);
        accountForm.setNameAccountOnTxtB(context.getAccount().getNameAccount());
        accountProfilePage = accountForm.clickOnSaveBtnFoot();
    }

    /**
     * Verifies the information in the profile account.
     */
    @Then("^the information account should be displayed in the Account Profile page$")
    public void displayTheInformationOnTheProfileOfNewAccount() {
        Assert.assertEquals(accountProfilePage.getNameAccountFromProfileHeader(), context.getAccount().getNameAccount());
    }

    /**
     * Verifies that account is displayed on recents list of account page.
     */
    @Then("^the account should be displayed on Accounts page$")
    public void displayAccountOnAccountsPage() {
        Assert.assertTrue(accountsPage.getListOfAccountsName().contains(context.getAccount().getNameAccount()));
    }
}
