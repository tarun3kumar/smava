package de.smava.pageobjects.landingpage;

import de.smava.pageobjects.registrationpage.CreditStep;
import de.smava.pageobjects.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;


/**
 * Encapsulates services offered loan selection section 
 *
 * Created by tarun on 6/14/16.
 */
public class LoanSelectionSection extends Page {

    private WebDriver webDriver;

    public LoanSelectionSection(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;

        if (!webDriver.getTitle().equals(
                    "SMAVA - Das Online-Vergleichsportal für Kredite | SMAVA")) {
            throw new IllegalStateException("This is not Smava landing page");
        }
    }

    public LoanSelectionSection selectCreditAmount(String creditAmount) {

        new Select(getElement(By.id("lsAmount"))).selectByVisibleText(
            creditAmount);

        return this;
    }

    public LoanSelectionSection selectDuration(String duration) {
        new Select(getElement(By.id("lsDuration"))).selectByVisibleText(
            duration);

        return this;
    }

    public LoanSelectionSection selectPurpose(String purpose) {
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
