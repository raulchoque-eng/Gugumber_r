/*
 * @(#) RestClientAPI.java Copyright (c) 2019 Jala Foundation.
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

import static io.restassured.RestAssured.given;

import java.util.Map;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.fjala.gugumber.salesforce.common.ReaderApplicationProperties;

/**
 * RestClientAPI class.
 *
 * @author Areliez Vargas
 * @version 0.0.1
 */
public class RestClientAPI {

    /**
     * Variable for the url base of API.
     */
    private String urlAPI;

    /**
     * Variable for the access token.
     */
    private String accessToken;

    /**
     * Variable for the content type.
     */
    private String contentType;

    /**
     * Variable for concat the url of API with the endpoint.
     */
    private String url;

    /**
     * Variable for the response.
     */
    private Response response;

    /**
     * Variable for the request.
     */
    private RequestSpecification request;

    /**
     * Variable for  initialize base api.
     */
    private static RestClientAPI instance;

    /**
     * Constructor of base API.
     */
    protected RestClientAPI() {
        initialize();
        requestAuthentication();
    }

    /**
     * Returns an instance of RestClientAPI.
     *
     * @return a instance.
     */
    public static RestClientAPI getInstance() {
        if (instance == null) {
            instance = new RestClientAPI();
        }
        return instance;
    }

    /**
     * Initializes the setting for the API.
     */
    private void initialize() {
        urlAPI = ReaderApplicationProperties.getInstance().getAppProperties().get("urlAPI");
        accessToken = ReaderApplicationProperties.getInstance().getAppProperties().get("Access-Token");
        contentType = ReaderApplicationProperties.getInstance().getAppProperties().get("Content-Type");
    }

    /**
     * Requests the authentication.
     */
    private void requestAuthentication() {
        request = given().headers("Content-Type", contentType)
                .auth().oauth2(accessToken);
    }

    /**
     * Returns a response after requesting a post.
     *
     * @param endpoint to do the request.
     * @param valuesForTheBody the
     * @return a response
     */
    public Response post(final String endpoint, final Map<String, String> valuesForTheBody) {
        url = urlAPI.concat(endpoint);
        response = request.body(valuesForTheBody)
                .when().post(url);
        return response;
    }

    /**
     * Returns a response after requesting a delete.
     *
     * @param endpoint to do the request.
     * @return a response.
     */
    public Response delete(final String endpoint) {
        url = urlAPI.concat(endpoint);
        response = request.when().delete(url);
        return response;
    }

    /**
     * Returns a response after requesting a delete.
     *
     * @param endpoint to do the request.
     * @return a response.
     */
    public Response get(final String endpoint) {
        url = urlAPI.concat(endpoint);
        response = request.when().get(url);
        return response;
    }
}
