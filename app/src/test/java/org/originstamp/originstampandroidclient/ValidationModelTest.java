package org.originstamp.originstampandroidclient;

import org.junit.Test;
import org.originstamp.originstampandroidclient.exceptions.InvalidApiKeyFormatException;
import org.originstamp.originstampandroidclient.exceptions.InvalidHashFormatException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * @author Jannik Bamberger (dev.jbamberger@gmail.com)
 */
public class ValidationModelTest {

    @Test
    public void validateCredentials() throws Exception {
        //both invalid
        try {
            ValidationModel.validateCredentials("", "");
            fail();
        } catch (InvalidApiKeyFormatException | InvalidHashFormatException ignored) {
        }
        //api invalid
        try {
            ValidationModel.validateCredentials("", "b06c52cf7b862a770cb0ce3133f5757bce22ac357ed7a1e0f2ed6677dea5583c");
            fail();
        } catch (InvalidApiKeyFormatException ignored) {
        }

        //hash invalid
        try {
            ValidationModel.validateCredentials("0628a264-a613-11e7-abc4-cec278b6b50a", "");
            fail();
        } catch (InvalidHashFormatException ignored) {
        }

        //both valid
        ValidationModel.validateCredentials("0628a264-a613-11e7-abc4-cec278b6b50a", "b06c52cf7b862a770cb0ce3133f5757bce22ac357ed7a1e0f2ed6677dea5583c");
    }

    @Test
    public void isValidHashFormat() throws Exception {
        assertFalse(ValidationModel.isValidHashFormat(null));
        assertFalse(ValidationModel.isValidHashFormat(""));
        assertFalse(ValidationModel.isValidHashFormat("dsafdasfsad"));
        assertTrue(ValidationModel.isValidHashFormat("b06c52cf7b862a770cb0ce3133f5757bce22ac357ed7a1e0f2ed6677dea5583c")); //sha256
        assertTrue(ValidationModel.isValidHashFormat("7ce520754c2570f7463aee709877e6570e542e6d")); //sha1
    }

    @Test
    public void isValidApiKeyFormat() throws Exception {
        assertFalse(ValidationModel.isValidApiKeyFormat(null));
        assertFalse(ValidationModel.isValidApiKeyFormat(""));
        assertFalse(ValidationModel.isValidApiKeyFormat("xxxxxxxx-xxxx-xxxx-xxxx-xxxxxxxxxxxx"));
        assertFalse(ValidationModel.isValidApiKeyFormat("0628a264-a613-11e7-abc4-fe3e-cec278b6b50a"));
        assertTrue(ValidationModel.isValidApiKeyFormat("0628a264-a613-11e7-abc4-cec278b6b50a"));
    }

    @Test
    public void isValidSHA256() throws Exception {
        assertFalse(ValidationModel.isValidSHA256(null));
        assertFalse(ValidationModel.isValidSHA256(""));
        assertFalse(ValidationModel.isValidSHA256("b06c52cf7b862a770cb0ce3133f5757bce22ac357ed7a1e0f2ed6677dea5583"));
        assertFalse(ValidationModel.isValidSHA256("b06c52cf7b862a770cb0ce3133f5757bce22ac357ed7a1e0f2ed6677dea5583cc"));
        assertTrue(ValidationModel.isValidSHA256("b06c52cf7b862a770cb0ce3133f5757bce22ac357ed7a1e0f2ed6677dea5583c"));
    }

    @Test
    public void isValidSHA1() throws Exception {
        assertFalse(ValidationModel.isValidSHA1(null));
        assertFalse(ValidationModel.isValidSHA1(""));
        assertFalse(ValidationModel.isValidSHA1("7ce520754c2570f7463aee709877e6570e542e6"));
        assertFalse(ValidationModel.isValidSHA1("7ce520754c2570f7463aee709877e6570e542e6dd"));
        assertTrue(ValidationModel.isValidSHA1("7ce520754c2570f7463aee709877e6570e542e6d"));
    }

    @Test
    public void isMailValid() throws Exception {
        assertFalse(ValidationModel.isMailValid(null));
        assertFalse(ValidationModel.isMailValid(""));
        assertFalse(ValidationModel.isMailValid("@"));
        assertTrue(ValidationModel.isMailValid("abc@def.gh"));
    }

}