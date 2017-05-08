package org.originstamp.originstampandroidclient;

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

class ValidationModel {
    /**
     * constructor which creates a new instance of the current class
     */
    public ValidationModel() {
    }

    /**
     * validates the input
     * @param pHash
     * @param pApiKey
     * @param pHashRequestDTO
     * @throws InvalidHashFormatException
     * @throws InvalidApiKeyFormatException
     * @throws InvalidCommentException
     * @throws InvalidMailFormatException
     * @throws InvalidUrlFormatException
     */
    public void validateStoreRequest(String pHash, String pApiKey, HashRequestDTO pHashRequestDTO)
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
            if (!this.isMailValid(pHashRequestDTO.getEmail())) {
                throw new InvalidMailFormatException();
            }
        }

        if (pHashRequestDTO.getUrl() != null) {
            // lowercase
            pHashRequestDTO.setUrl(pHashRequestDTO.getUrl().toLowerCase());

            if (!this.isValidApiKeyFormat(pHashRequestDTO.getUrl())) {
                throw new InvalidUrlFormatException();
            }
        }
    }

    /**
     * validates the api key and the hash format
     *
     * @param pApiKey
     * @param pHash
     * @throws InvalidHashFormatException
     * @throws InvalidApiKeyFormatException
     */
    public void validateCredentials(String pApiKey, String pHash) throws InvalidHashFormatException, InvalidApiKeyFormatException {
        if (!this.isValidHashFormat(pHash)) {
            throw new InvalidHashFormatException();
        }

        if (!this.isValidApiKeyFormat(pApiKey)) {
            throw new InvalidApiKeyFormatException();
        }
    }

    /**
     * checks whether a given hash input is valid or not
     *
     * @param pHash
     * @return
     */
    private boolean isValidHashFormat(String pHash) {
        // check if empty
        if (pHash == null || pHash.isEmpty()) {
            return false;
        }

        // check if too long
        if (pHash.length() > 256) {
            // invalid
            return false;
        }

        if (this.isValidSHA1(pHash)) {
            return true;
        } else if (this.isValidSHA256(pHash)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * checks whether a given api is valid or not
     *
     * @return
     */
    private boolean isValidApiKeyFormat(String pApiKey) {
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
     *
     * @param pHash
     * @return
     */
    private boolean isValidSHA256(String pHash) {
        return pHash.matches("[A-Fa-f0-9]{64}");
    }

    /**
     * validates if a given input hash is in SHA1 format
     *
     * @param s
     * @return
     */
    private boolean isValidSHA1(String s) {
        return s.matches("[a-fA-F0-9]{40}");
    }

    /**
     * validates an input mail address
     *
     * @param s
     * @return
     */
    private boolean isMailValid(String s) {
        return s.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
    }

}
