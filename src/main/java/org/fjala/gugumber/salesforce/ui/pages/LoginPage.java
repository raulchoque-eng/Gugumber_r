/*
 * @(#) LoginPage.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of Jala
 * Foundation, Inc. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 *
 */

package org.fjala.gugumber.salesforce.ui.pages;

import org.fjala.gugumber.salesforce.common.ReaderApplicationProperties;
import org.fjala.gugumber.salesforce.ui.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * LoginPage class.
 *
 * @author Areliez Vargas
 * @version 0.0.1
 */
public class LoginPage extends BasePage {

    @FindBy(id = "username")
    private WebElement userNameTxtB;

    @FindBy(id = "password")
    private WebElement passwordTxtB;

    @FindBy(id = "Login")
    private WebElement loginBtn;

    @FindBy(id = "theloginform")
    private WebElement loginForm;

    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(loginForm));
    }

    /**
     * Log in in the application.
     * @param userName of the user.
     * @param password of the user.
     */
    public void login(String userName, String password){
        setUserName(ReaderApplicationProperties.getInstance().getAppProperties().get(userName));
        setPassword(ReaderApplicationProperties.getInstance().getAppProperties().get(password));
        clickNextSignInBtn();
    }

    public void setUserName(String userName) {
        userNameTxtB.sendKeys(userName);
    }

    public void setPassword(String password) {
        passwordTxtB.sendKeys(password);
    }

    public void clickNextSignInBtn() {
        loginBtn.click();
    }
}

