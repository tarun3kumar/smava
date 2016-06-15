package de.smava.pageobjects.landingpage;

import de.smava.pageobjects.registrationpage.CreditStep;
import de.smava.pageobjects.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


/**
 * Page object for result section on landing page
 *
 * Created by tarun on 6/15/16.
 */
public class ResultSection extends Page {

    private WebDriver webDriver;

    public ResultSection(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
    }

    public int getOfferCount() {
        return getElements(By.cssSelector(".offer-item")).size();
    }

    public String getMonthlyRate(String bank) {
        return getElement(By.cssSelector("a[id $= '" + bank + "']>.info2>.nub"))
            .getText();
    }

    public String getBorrowingRate(String bank) {
        return getElement(By.cssSelector("a[id $= '" + bank + "']>.info4>.nub"))
            .getText();
    }

    public String getEffectiveAnnualInterestRate(String bank) {
        return getElement(By.cssSelector("a[id $= '" + bank + "']>.nub"))
            .getText();
    }

    public CreditStep continueToGivenBank(String bankName) {
        getElement(By.cssSelector("a[id $= '" + bankName + "']>button"))
            .click();

        return new CreditStep(webDriver);
    }


}
