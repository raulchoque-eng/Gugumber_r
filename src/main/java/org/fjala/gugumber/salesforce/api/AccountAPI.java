/*
 * @(#) AccountAPI.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of Jala
 * Foundation, Inc. ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */

package org.fjala.gugumber.salesforce.api;

import io.restassured.response.Response;

import static org.fjala.gugumber.salesforce.api.Endpoints.ACCOUNT_ENDPOINT;

/**
 * AccountAPI class.
 *
 * @author Areliez Vargas
 * @version 0.0.1
 */
public class AccountAPI {

    /**
     * Variable for the rest client.
     */
    private RestClientAPI restClient;

    /**
     * Variable for the final endpoint.
     */
    private String finalEndpoint;

    /**
     * Constructor of AccountAPI.
     */
    protected AccountAPI() {
        restClient = RestClientAPI.getInstance();
    }

    /**
     * Returns the instance the account API.
     *
     * @return a account API.
     */
    public static AccountAPI getInstance() {
        return new AccountAPI();
    }

    /**
     * Deletes an account by id.
     *
     * @param accountId to concat with the base endpoint.
     */
    public void deleteAccount(final int accountId) {
        finalEndpoint = ACCOUNT_ENDPOINT.concat("/".concat(String.valueOf(accountId)));
        final Response response = restClient.delete(finalEndpoint);
    }
}
