package de.smava.core;

import org.junit.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


/**
 * Instantiates and stop driver
 *
 * Created by tarun on 6/14/16.
 */
public class SelTestCase {

    private WebDriver webDriver;

    public WebDriver getWebDriver() {
        return webDriver;
    }

    @Before public void setupDriver() {
        webDriver = new FirefoxDriver();
    }

    @After public void stopDriver() {
        webDriver.quit();
    }

}
