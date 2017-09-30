package org.originstamp.originstampandroidclient;

import org.originstamp.originstampandroidclient.exceptions.InvalidApiKeyFormatException;
import org.originstamp.originstampandroidclient.exceptions.OriginStampBadRequestException;
import org.originstamp.originstampandroidclient.exceptions.OriginStampForbiddenException;
import org.originstamp.originstampandroidclient.exceptions.OriginStampInternalServerException;
import org.originstamp.originstampandroidclient.exceptions.OriginStampRateLimitException;
import org.originstamp.originstampandroidclient.exceptions.OriginStampResourceNotFoundException;

import retrofit2.Response;

/**
 * Created by Thomas on 04.04.17.
 */

final class ResponseValidatorModel {

    private ResponseValidatorModel() {
        throw new AssertionError("No instances of ResponseValidatorModel!");
    }

    /**
     * handles the response message from the api
     *
     * @param pResponse
     * @throws InvalidApiKeyFormatException
     */
    static Object handleResponse(Response pResponse) throws OriginStampBadRequestException, OriginStampForbiddenException, OriginStampResourceNotFoundException, OriginStampRateLimitException, OriginStampInternalServerException {
        // get result code
        int resultCode = pResponse.code();

        // validating the result code
        switch (resultCode) {
            case 200: // all fine
                return pResponse.body();
            case 400:
                //FIXME: either code 300 or code 400 is wrong.
                throw new OriginStampBadRequestException("Your request parameters are invalid. HTTP Code: 300. " + pResponse.body().toString());
            case 403:
                throw new OriginStampForbiddenException("Please check your API Key. It seems to be invalid. HTTP Code: 403." + pResponse.body().toString());
            case 404:
                throw new OriginStampResourceNotFoundException("The resource is not available. Please check your connection. HTTP Code: 404." + pResponse.body().toString());
            case 429:
                throw new OriginStampRateLimitException("Rate Limit exceeded. Please contact the administrators for a premium API key HTTP Code: 429." + pResponse.body().toString());
            case 500:
                throw new OriginStampInternalServerException("An internal error occured. Please contact the administrators of OriginStamp HTTP Code: 500." + pResponse.body().toString());
            default:
                return pResponse.body();
        }
    }
}
