package org.originstamp.originstampandroidclient;

import org.originstamp.originstampandroidclient.commons.HashRequestDTO;
import org.originstamp.originstampandroidclient.exceptions.InvalidApiKeyFormatException;
import org.originstamp.originstampandroidclient.exceptions.InvalidCommentException;
import org.originstamp.originstampandroidclient.exceptions.InvalidHashFormatException;
import org.originstamp.originstampandroidclient.exceptions.InvalidMailFormatException;
import org.originstamp.originstampandroidclient.exceptions.InvalidUrlFormatException;

/**
 * Created by Thomas on 04.04.17.
 */

class PreprocessorModel {
    /**
     * preprocesses the hash request. Validates the input and makes it lowercase
     *
     * @param pHashRequestDTO
     * @return
     */
    public void preprocessRequest(String pHash, String pApiKey, HashRequestDTO pHashRequestDTO) throws InvalidHashFormatException, InvalidApiKeyFormatException, InvalidUrlFormatException, InvalidMailFormatException, InvalidCommentException {
        // create new validation model
        ValidationModel validationModel = new ValidationModel();
        // validate input
        validationModel.validateStoreRequest(pHash, pApiKey, pHashRequestDTO);
    }
}
