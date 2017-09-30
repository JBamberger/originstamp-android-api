package org.originstamp.originstampandroidclient;

import org.originstamp.originstampandroidclient.commons.HashRequestDTO;
import org.originstamp.originstampandroidclient.commons.HashResponseDTO;
import org.originstamp.originstampandroidclient.exceptions.InvalidApiKeyFormatException;
import org.originstamp.originstampandroidclient.exceptions.InvalidCommentException;
import org.originstamp.originstampandroidclient.exceptions.InvalidHashFormatException;
import org.originstamp.originstampandroidclient.exceptions.InvalidMailFormatException;
import org.originstamp.originstampandroidclient.exceptions.InvalidUrlFormatException;
import org.originstamp.originstampandroidclient.exceptions.OriginStampBadRequestException;
import org.originstamp.originstampandroidclient.exceptions.OriginStampForbiddenException;
import org.originstamp.originstampandroidclient.exceptions.OriginStampInternalServerException;
import org.originstamp.originstampandroidclient.exceptions.OriginStampRateLimitException;
import org.originstamp.originstampandroidclient.exceptions.OriginStampResourceNotFoundException;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * Created by Thomas on 04.04.17.
 */
public class OriginStampAPI {
    // endpoint
    private static final String API_ENDPOINT = "http://api.originstamp.org/api/";
    // member variable
    private String apiKey;
    private final OriginStampService api;

    /**
     * constructor which creates a new instance of the current class
     */
    public OriginStampAPI(String pApiKey) {
        this(pApiKey, API_ENDPOINT);
    }

    /**
     * constructor
     *
     * @param pApiKey
     * @param pEndpoint
     */
    public OriginStampAPI(String pApiKey, String pEndpoint) {
        this.apiKey = pApiKey;
        api = new Retrofit.Builder()
                .baseUrl(pEndpoint)
                .addConverterFactory(JacksonConverterFactory.create())
                .build()
                .create(OriginStampService.class);
    }

    /**
     * sets the api key
     *
     * @param apiKey
     */
    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    /**
     * sends a post request with the request body to store a new hash at originstamp
     *
     * @return
     */
    public HashResponseDTO storeHashInformation(String pHash, HashRequestDTO pHashRequestDTO) throws InvalidCommentException, InvalidMailFormatException, InvalidUrlFormatException, InvalidApiKeyFormatException, InvalidHashFormatException, IOException, OriginStampInternalServerException, OriginStampRateLimitException, OriginStampResourceNotFoundException, OriginStampBadRequestException, OriginStampForbiddenException {
        // preprocessing
        PreprocessorModel.preprocessRequest(pHash, this.apiKey, pHashRequestDTO);

        // call
        Call<HashResponseDTO> call = api.storeHashInformation(pHash, this.apiKey, pHashRequestDTO);

        // execute the request
        Response<HashResponseDTO> response = call.execute();

        // handling the response and throwing exceptions if necessary
        return (HashResponseDTO) ResponseValidatorModel.handleResponse(response);
    }

    /**
     * requests the seed file for a hash
     *
     * @param pHash
     * @return
     */
    public String getSeed(String pHash) throws InvalidCommentException, InvalidMailFormatException, InvalidUrlFormatException, InvalidApiKeyFormatException, InvalidHashFormatException, IOException, OriginStampInternalServerException, OriginStampRateLimitException, OriginStampResourceNotFoundException, OriginStampBadRequestException, OriginStampForbiddenException {
        // preprocessing
        PreprocessorModel.preprocessRequest(pHash, this.apiKey, null);

        // call
        Call<ResponseBody> call = api.getSeedString(pHash, this.apiKey);

        // execute the request
        Response<ResponseBody> response = call.execute();

        // validation
        ResponseBody responseBody = (ResponseBody) ResponseValidatorModel.handleResponse(response);

        // handling the response and throwing exceptions if necessary
        return responseBody.string();
    }

    /**
     * requesting hash information from a given hash string in hex representation. If the hash does not exists,
     * a new entry will be created on OriginStamp.
     *
     * @param pHash
     * @return
     * @throws IOException
     */
    public HashResponseDTO getHashInformation(String pHash) throws OriginStampInternalServerException, OriginStampRateLimitException, OriginStampResourceNotFoundException, OriginStampBadRequestException, OriginStampForbiddenException, IOException, InvalidHashFormatException, InvalidApiKeyFormatException {
        // lower case
        pHash = pHash.toLowerCase();
        this.apiKey = this.apiKey.toLowerCase();

        // validation
        ValidationModel.validateCredentials(this.apiKey, pHash);

        // call
        Call<HashResponseDTO> call = api.getHashInformation(pHash, this.apiKey);

        // execute the request
        Response<HashResponseDTO> response = call.execute();

        // handling the response and throwing exceptions if necessary
        return (HashResponseDTO) ResponseValidatorModel.handleResponse(response);
    }

    /**
     * requesting hash information for a given input byte array. The byte array
     * is hashed with SHA256 and converted into a hex representation.
     *
     * @param pInput
     * @return
     * @throws NoSuchAlgorithmException
     */
    public HashResponseDTO getHashInformation(byte[] pInput) throws NoSuchAlgorithmException, IOException, InvalidHashFormatException, InvalidApiKeyFormatException, OriginStampInternalServerException, OriginStampRateLimitException, OriginStampResourceNotFoundException, OriginStampBadRequestException, OriginStampForbiddenException {
        // converting input to sha256 hash
        return this.getHashInformation(
                getSha256(pInput));
    }

    /**
     * calculates the SHA 256 of an input array
     *
     * @param pInput
     * @return
     */
    public String getSha256(byte[] pInput) throws NoSuchAlgorithmException {
        return HashModel.getSHA256(pInput);
    }


}
