package org.originstamp.originstampandroidclient;

import android.support.annotation.VisibleForTesting;

import org.originstamp.originstampandroidclient.commons.HashRequestDTO;
import org.originstamp.originstampandroidclient.exceptions.InvalidApiKeyFormatException;
import org.originstamp.originstampandroidclient.exceptions.InvalidCommentException;
import org.originstamp.originstampandroidclient.exceptions.InvalidHashFormatException;
import org.originstamp.originstampandroidclient.exceptions.InvalidMailFormatException;
import org.originstamp.originstampandroidclient.exceptions.InvalidUrlFormatException;

import java.util.UUID;

/**
 * Created by Thomas on 04.04.17.
 */

final class ValidationModel {

    private ValidationModel() {
        throw new AssertionError("No instances of ValidatorModel!");
    }

    /**
     * validates the input
     */
    static void validateStoreRequest(String pHash, String pApiKey, HashRequestDTO pHashRequestDTO)
            throws InvalidHashFormatException,
            InvalidApiKeyFormatException, InvalidCommentException, InvalidMailFormatException, InvalidUrlFormatException {

        // validating the credentials
        validateCredentials(pApiKey, pHash);

        if (pHashRequestDTO == null) {
            return;
        }

        if (pHashRequestDTO.getComment() != null) {
            if (pHashRequestDTO.getComment().length() > 256) {
                throw new InvalidCommentException();
            }
        }

        if (pHashRequestDTO.getEmail() != null) {
            // lowercase
            pHashRequestDTO.setEmail(pHashRequestDTO.getEmail().toLowerCase());

            // validation of the mail address
            if (!isMailValid(pHashRequestDTO.getEmail())) {
                throw new InvalidMailFormatException();
            }
        }

        if (pHashRequestDTO.getUrl() != null) {
            // lowercase
            pHashRequestDTO.setUrl(pHashRequestDTO.getUrl().toLowerCase());

            if (!isValidApiKeyFormat(pHashRequestDTO.getUrl())) {
                throw new InvalidUrlFormatException();
            }
        }
    }

    /**
     * validates the api key and the hash format
     */
    static void validateCredentials(String pApiKey, String pHash) throws InvalidHashFormatException, InvalidApiKeyFormatException {
        if (!isValidHashFormat(pHash)) {
            throw new InvalidHashFormatException();
        }

        if (!isValidApiKeyFormat(pApiKey)) {
            throw new InvalidApiKeyFormatException();
        }
    }

    /**
     * checks whether a given hash input is valid or not
     */
    @VisibleForTesting
    static boolean isValidHashFormat(String pHash) {
        // check if empty
        if (pHash == null || pHash.isEmpty() || pHash.length() > 256) {
            return false;
        }

        return isValidSHA1(pHash) || isValidSHA256(pHash);
    }

    /**
     * checks whether a given api is valid or not
     */
    @VisibleForTesting
    static boolean isValidApiKeyFormat(String pApiKey) {
        // check if empty
        if (pApiKey == null || pApiKey.isEmpty()) {
            return false;
        }

        // try to uuid
        try {
            // converting to uuid
            UUID.fromString(pApiKey);
            // convert successful
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * validates if a given input hash is a valid sha256
     */
    @VisibleForTesting
    static boolean isValidSHA256(String pHash) {
        return pHash != null && pHash.matches("[A-Fa-f0-9]{64}");
    }

    /**
     * validates if a given input hash is in SHA1 format
     */
    @VisibleForTesting
    static boolean isValidSHA1(String s) {
        return s != null && s.matches("[a-fA-F0-9]{40}");
    }

    /**
     * validates an input mail address
     */
    @VisibleForTesting
    static boolean isMailValid(String s) {
        return s != null && s.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
    }

}
