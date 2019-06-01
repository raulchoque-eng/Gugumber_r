/*
 * @(#) ClientRestApi.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av. Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of Jala
 * Foundation, Inc. ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */

package org.fjala.gugumber.salesforce.api;

import org.fjala.gugumber.salesforce.entities.Component;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

/**
 * ClientRestApi class.
 *
 * @author Raul Choque
 * @version 0.0.1
 */
public class ClientRestApi {

    /**
     * Constant data URL_BASE, for made a request.
     */
    private static final String URL_BASE = "https://na132.salesforce.com/services/data/v45.0/sobjects/";

    /**
     * Constant data TOKEN, for made a request.
     */
    private static final String TOKEN = "";

    /**
     * Creates a component, use Rest API and method POST.
     *
     * @param component is a data required for made a request.
     * @param endpoint is a data for complete the URl and mad a request.
     */
    public void createComponent(Component component, String endpoint) {
        Map<String, String> componentInMap = component.toMap();
        String path = URL_BASE.concat(endpoint);
        given().
            auth().
            oauth2(TOKEN).
            contentType(JSON).
            body(componentInMap).
        when().
            post(path).
        then().
            assertThat().
            statusCode(200).
            and().
            contentType(JSON);
    }
}
