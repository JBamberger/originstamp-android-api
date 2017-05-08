package org.originstamp.originstampandroidclient;

import org.originstamp.originstampandroidclient.commons.HashRequestDTO;
import org.originstamp.originstampandroidclient.commons.HashResponseDTO;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by Thomas on 04.04.17.
 */
public interface OriginStampService {
    @GET("{hash_string}")
    Call<HashResponseDTO> getHashInformation(
            @Path("hash_string") String pHash,
            @Header("Authorization") String apiKey
    );

    @POST("{hash_string}")
    Call<HashResponseDTO> storeHashInformation(
            @Path("hash_string") String pHash,
            @Header("Authorization") String apiKey,
            @Body HashRequestDTO pHashRequestDTO
    );

    @GET("download/seed/{hash_string}")
    Call<ResponseBody> getSeedString(
            @Path("hash_string") String pHash,
            @Header("Authorization") String apiKey
    );
}
