/*
 * @(#) Account.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av. Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of Jala
 * Foundation, Inc. ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */

package org.fjala.gugumber.salesforce.entities;

import java.util.HashMap;
import java.util.Map;

import org.fjala.gugumber.core.StrategySetter;

/**
 * Account class.
 *
 * @author Areliez Vargas
 * @version 0.0.1
 */
public class Account {

    /**
     * Constant for key of name account.
     */
    private static final String NAME_ACCOUNT = "Account Name";

    /**
     * Variable for the name account of an Account.
     */
    private String nameAccount;

    /**
     * Returns the name account.
     *
     * @return name account as string.
     */
    public String getNameAccount() {
        return nameAccount;
    }

    /**
     * Sets the name of an Account sending a string.
     *
     * @param nameAccount for the name of the account.
     */
    public void setNameAccount(final String nameAccount) {
        this.nameAccount = nameAccount;
    }

    /**
     * Sets the values of an Account sending a map with the information to set.
     *
     * @param accountMap to set the information.
     */
    public void setAccountInformation(final Map<String, String> accountMap) {
        HashMap<String, StrategySetter> strategyMap = composeStrategyMap(accountMap);
        accountMap.keySet().forEach(key -> strategyMap.get(key).executeMethod());
    }

    /**
     * Returns a map with the information the account.
     *
     * @param accountMap to set the information.
     * @return strateg ma with the information of account.
     */
    private HashMap<String, StrategySetter> composeStrategyMap(final Map<String, String> accountMap) {
        HashMap<String, StrategySetter> strategyMap = new HashMap<>();
        strategyMap.put(NAME_ACCOUNT, () -> setNameAccount(accountMap.get(NAME_ACCOUNT)));
        return strategyMap;
    }
}
