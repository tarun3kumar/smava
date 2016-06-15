package de.smava.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;


/**
 * Page object for the services offered by landing page
 *
 * Created by tarun on 6/14/16.
 */
public class LandingPage extends Page {

    private WebDriver webDriver;

    public LandingPage(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;

        if (
            !webDriver.getTitle().equals(
                    "SMAVA - Das Online-Vergleichsportal für Kredite | SMAVA")) {
            throw new IllegalStateException("This is no Smava landing page");
        }
    }

    public LandingPage selectCreditAmount(String creditAmount) {

        new Select(getElement(By.id("lsAmount"))).selectByVisibleText(
            creditAmount);

        return this;
    }

    public LandingPage selectDuration(String duration) {
        new Select(getElement(By.id("lsDuration"))).selectByVisibleText(
            duration);

        return this;
    }

    public LandingPage selectPurpose(String purpose) {
        new Select(getElement(By.id("lsCategory"))).selectByVisibleText(
            purpose);

        return this;
    }

    public CreditStep clickContinue() {
        waitForElementVisibility(By.cssSelector("a[id ^= 'forwardButton']"))
            .click();

        return new CreditStep(webDriver);
    }

}
