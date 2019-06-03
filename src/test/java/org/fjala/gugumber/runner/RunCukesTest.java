/*
 * @(#) RunCukesTest.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av. Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of Jala
 * Foundation, Inc. ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */

package org.fjala.gugumber.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.fjala.gugumber.core.report.GeneratorReport;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

/**
 * RunCukesTest class.
 *
 * @author Raul Choque
 * @version 0.0.1
 */
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber", "json:target/cucumber.json"},
        glue = {"org/fjala/gugumber/steps"},
        features = {"src/test/resources/features/event.feature"},

        monochrome = true)

public class RunCukesTest extends AbstractTestNGCucumberTests {

    @BeforeTest
    public void beforeExecution() {

    }
    /**
     * Executes the project and generate it report.
     */
    @AfterTest
    public void afterExecution() {
        //WebDriverManager.getInstance().getWebDriver().close();
        GeneratorReport.getInstance().generateReport();
    }
}
