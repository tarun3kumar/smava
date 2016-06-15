package de.smava;

import de.smava.core.SelTestCase;

import de.smava.pageobjects.registrationpage.CreditStep;
import de.smava.pageobjects.landingpage.LoanSelectionSection;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;


public class LoanSelectionTest extends SelTestCase {
    @Test 
    public void shouldDisplayLoanAttributesOnResultPage() {
        String loanAmount = "2.750 €";
        String duration = "24 Monate";
        String purpose = "Wohnen";

        getWebDriver().get("http://www.smava.de/");

        CreditStep resultPage = new LoanSelectionSection(getWebDriver())
            .selectCreditAmount(loanAmount).selectDuration(duration)
            .selectPurpose(purpose).clickContinue();

        assertThat("Credit amount is wrong on result page",
            resultPage.getCreditAmount(), is(equalTo(loanAmount)));
        assertThat("Duration is wrong on result page", resultPage.getDuration(),
            is(equalTo(duration)));
        assertThat("Purpose is wrong on result page", resultPage.getPurpose(),
            is(equalTo(purpose)));
    }
}
