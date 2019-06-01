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

package org.fjala.gugumber.core;

/**
 * StrategySetter class.
 *
 * @author Cristian Lujan
 * @version 0.0.1
 */
@FunctionalInterface
public interface StrategySetter {

    /**
     * Executes method for a Page or an entity.
     */
    void executeMethod();
}
