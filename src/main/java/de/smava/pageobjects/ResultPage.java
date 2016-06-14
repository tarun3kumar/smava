package de.smava.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


/**
 * Represents services offered by results page
 *
 * Created by tarun on 6/14/16.
 */
public class ResultPage {

    private WebDriver webDriver;

    public ResultPage(WebDriver webDriver) {
        this.webDriver = webDriver;

        if (
            !webDriver.getTitle().equals(
                    "Kredit beantragen | Kreditantrag in 4 Schritten | SMAVA")) {
            throw new IllegalStateException("This is not Result page");
        }
    }

    public String getCreditAmount() {
        return webDriver.findElement(By.cssSelector(".amount-column>.value"))
            .getText();
    }

    public String getDuration() {
        return webDriver.findElement(By.cssSelector(".amount-column+li>.value"))
            .getText();
    }

    public String getPurpose() {
        return webDriver.findElement(By.cssSelector(".amount-column+li>.value"))
            .getText();
    }


}
