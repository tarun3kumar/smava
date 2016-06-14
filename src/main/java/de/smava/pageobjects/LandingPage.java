package de.smava.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;


/**
 * Page object for the services offered by landing page
 *
 * Created by tarun on 6/14/16.
 */
public class LandingPage {

    private WebDriver webDriver;

    public LandingPage(WebDriver webDriver) {
        this.webDriver = webDriver;

        if (
            !webDriver.getTitle().equals(
                    "SMAVA - Das Online-Vergleichsportal für Kredite | SMAVA")) {
            throw new IllegalStateException("This is no Smava landing page");
        }
    }

    public LandingPage selectCreditAmount(String creditAmount) {

        new Select(webDriver.findElement(By.id("lsAmount")))
            .selectByVisibleText(creditAmount);

        return this;
    }

    public LandingPage selectDuration(String duration) {
        new Select(webDriver.findElement(By.id("lsDuration")))
            .selectByVisibleText(duration);

        return this;
    }

    public LandingPage selectPurpose(String purpose) {
        new Select(webDriver.findElement(By.id("lsCategory")))
            .selectByVisibleText(purpose);

        return this;
    }

    public ResultPage clickContinue() {
        webDriver.findElement(By.cssSelector("a[id ^= 'forwardButton']"))
            .click();

        return new ResultPage(webDriver);
    }

}
