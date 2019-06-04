/*
 * @(#) PageLayoutFactory.java Copyright (c) 2019 Jala Foundation.
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

import org.fjala.gugumber.salesforce.ui.pages.Home.HomeClassicPage;
import org.fjala.gugumber.salesforce.ui.pages.Home.HomeLightningPage;
import org.fjala.gugumber.salesforce.ui.pages.Home.HomePage;
import org.fjala.gugumber.salesforce.ui.pages.account.AccountsClassicPage;
import org.fjala.gugumber.salesforce.ui.pages.account.AccountsLightningPage;
import org.fjala.gugumber.salesforce.ui.pages.account.AccountsPage;
import org.fjala.gugumber.salesforce.ui.pages.app.BaseAppClassicPage;
import org.fjala.gugumber.salesforce.ui.pages.app.BaseAppLightningPage;
import org.fjala.gugumber.salesforce.ui.pages.app.BaseAppPage;
import org.fjala.gugumber.salesforce.ui.pages.events.CalendarLightningPage;

/**
 * PageLayoutFactory class.
 *
 * @author Areliez Vargas
 * @version 0.0.1
 */
public class PageLayoutFactory {

    /**
     * Constant for the page layout type.
     */
    private static final PageLayoutType PAGE_LAYOUT_TYPE = PageLayoutConfig.getPageLayoutName();

    /**
     * Constant for the message of exception.
     */
    private static final String MESSAGE_FOR_UNKNOWN_LAYOUT = "Unknown layout type";

    /**
     * Constructor of PageLayoutFactory.
     */
    protected PageLayoutFactory() {}

    /**
     * Returns the home page according the page layout.
     *
     * @return a home page.
     */
    public static HomePage getHomePageManager() {
        final HomePage homePage;
        switch (PAGE_LAYOUT_TYPE) {
            case CLASSIC:
                homePage = new HomeClassicPage();
                break;
            case LIGHTNING:
                homePage = new HomeLightningPage();
                break;
            default:
                throw new RuntimeException(MESSAGE_FOR_UNKNOWN_LAYOUT);
        }
        return homePage;
    }

    /**
     * Gets the Base App page according the page layout.
     *
     * @return a base app page.
     */
     public static BaseAppPage getBaseAppPage() {
        final BaseAppPage baseAppPage;
        switch (PAGE_LAYOUT_TYPE) {
            case CLASSIC:
                baseAppPage = new BaseAppClassicPage();
                break;
            case LIGHTNING:
                baseAppPage = new BaseAppLightningPage();
                break;
            default:
                throw new RuntimeException(MESSAGE_FOR_UNKNOWN_LAYOUT);
        }
        return baseAppPage;
    }

    /**
     * Returns the Accounts page according the page layout.
     *
     * @return a the accounts page.
     */

    public static AccountsPage getAccountsPage() {
        final AccountsPage accountsPage;
        switch (PAGE_LAYOUT_TYPE) {
            case CLASSIC:
                accountsPage = new AccountsClassicPage();
                break;
            case LIGHTNING:
                accountsPage = new AccountsLightningPage();
                break;
            default:
                throw new RuntimeException(MESSAGE_FOR_UNKNOWN_LAYOUT);
        }
        return accountsPage;
    }

    /**
     * Returns a Calendar lightning page.
     *
     * @return a CalendarLightningPage class.
     */
    public static CalendarLightningPage getCalendarPage() {
        final CalendarLightningPage calendarPage;
        switch (PAGE_LAYOUT_TYPE) {
            case LIGHTNING:
                calendarPage = new CalendarLightningPage();
                break;
            default:
                throw new RuntimeException(MESSAGE_FOR_UNKNOWN_LAYOUT);
        }
        return calendarPage;
    }
}
