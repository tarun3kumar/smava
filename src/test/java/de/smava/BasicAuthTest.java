package de.smava;

import de.smava.core.SelTestCase;

import org.junit.Test;


/**
 * Tests Basic Auth
 *
 * Created by tarun on 6/14/16.
 */
public class BasicAuthTest extends SelTestCase {

    @Test 
    public void shouldLoginUsingBasicAuthCredentials() {
        getWebDriver().get(
            "https://ostdteam:ostdteam@test.scorecompass.ostdlabs.com/");
    }
}
