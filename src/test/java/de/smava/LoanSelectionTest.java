package de.smava;

import de.smava.core.SelTestCase;

import de.smava.pageobjects.LandingPage;
import de.smava.pageobjects.ResultPage;

import static org.hamcrest.CoreMatchers.*;

import static org.hamcrest.MatcherAssert.*;

import org.junit.Test;


public class LoanSelectionTest extends SelTestCase {
    @Test public void shouldDisplayLoanAttributesOnResultPage() {
        String loanAmount = "2.750 €";
        String duration = "24 Monate";
        String purpose = "Wohnen";

        getWebDriver().get("http://www.smava.de/");

        ResultPage resultPage = new LandingPage(getWebDriver())
            .selectCreditAmount(loanAmount).selectDuration(duration)
            .selectPurpose(purpose).clickContinue();

        assertThat("Credit amount is wrong on landing page",
            resultPage.getCreditAmount(), is(equalTo(loanAmount)));
    }
}
