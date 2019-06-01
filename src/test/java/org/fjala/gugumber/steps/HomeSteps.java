/*
 * @(#) HomeSteps.java Copyright (c) 2019 Jala Foundation.
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

import cucumber.api.java.en.When;
import org.fjala.gugumber.salesforce.ui.PageTransporter;
import org.fjala.gugumber.salesforce.ui.pages.Home.HomePage;

/**
 * HomeSteps class for steps definitions.
 *
 * @author Areliez Vargas
 * @version 0.0.1
 */
public class HomeSteps {

    /**
     * Variable for the page transporter.
     */
    private PageTransporter pageTransporter = PageTransporter.getInstance();

    /**
     * Variable for the home page.
     */
    private HomePage homePage;

    /**
     * Navigates to the home page.
     */
    @When("^I navigate to the Home page$")
    public void navigateToThePage() {
        homePage = pageTransporter.navigateToHomePage();
    }
}
