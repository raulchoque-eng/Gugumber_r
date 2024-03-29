/*
 * @(#) PageTransporter.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of Jala
 * Foundation, Inc. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */

package org.fjala.gugumber.salesforce.ui;

import java.net.MalformedURLException;
import java.net.URL;

import org.fjala.gugumber.core.selenium.WebDriverManager;
import org.fjala.gugumber.salesforce.common.ReaderApplicationProperties;
import org.fjala.gugumber.salesforce.ui.pages.events.CalendarLightningPage;
import org.fjala.gugumber.salesforce.ui.pages.Home.HomePage;
import org.fjala.gugumber.salesforce.ui.pages.LoginPage;

import org.openqa.selenium.WebDriver;

/**
 * PageTransporter class.
 *
 * @author Areliez Vargas
 * @version 0.0.1
 */
public class PageTransporter {

    /**
     * Variable to initializes the PageTransporter.
     */
    private static PageTransporter instance;

    /**
     * Variable for webdriver.
     */
    private WebDriver webDriver;

    /**
     * Constant for the page layout type.
     */
    private static final PageLayoutType PAGE_LAYOUT_TYPE = PageLayoutConfig.getPageLayoutName();

    /**
     * Constant for the message of exception.
     */
    private static final String MESSAGE_FOR_UNKNOWN_LAYOUT = "Unknown layout type";

    /**
     * Constructor of page transporter.
     */
    protected PageTransporter() {
        initialize();
    }

    /**
     * Gets instance of page transporter.
     *
     * @return a new instance if it was initialised.
     */
    public static PageTransporter getInstance() {
        if (instance == null) {
            instance = new PageTransporter();
        }
        return instance;
    }

    /**
     * Initializes the attributes.
     */
    private void initialize() {
        webDriver = WebDriverManager.getInstance().getWebDriver();
    }

    /**
     * Navigates to a page sending the url.
     *
     * @param url for navigate.
     */
    private void goToURL(final String url) {
        try {
            webDriver.navigate().to(new URL(url));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Navigates to the login page.
     *
     * @return a new login page.
     */
    public LoginPage navigateToLoginPage() {
        goToURL(ReaderApplicationProperties.getInstance().getAppProperties().get("login"));
        return new LoginPage();
    }

    /**
     * Navigates a the home page according to the page layout.
     *
     * @return a home page according to the page layout.
     */
    public HomePage navigateToHomePage() {
        switch (PAGE_LAYOUT_TYPE) {
            case CLASSIC:
                goToURL(ReaderApplicationProperties.getInstance().getAppProperties().get("classic-url"));
                break;
            case LIGHTNING:
                goToURL(ReaderApplicationProperties.getInstance().getAppProperties().get("lightning-url"));
                break;
            default:
                throw new RuntimeException(MESSAGE_FOR_UNKNOWN_LAYOUT);
        }
        return PageLayoutFactory.getHomePageManager();
    }

    public  CalendarLightningPage navigateToCalendarPage() {
        switch (PAGE_LAYOUT_TYPE) {
            case LIGHTNING:
                String url = "https://na132.lightning.force.com/lightning/o/Event/home";
                goToURL(url);
                break;
            default:
                throw new  RuntimeException(MESSAGE_FOR_UNKNOWN_LAYOUT);
        }
        return PageLayoutFactory.getCalendarPage();
    }
}
