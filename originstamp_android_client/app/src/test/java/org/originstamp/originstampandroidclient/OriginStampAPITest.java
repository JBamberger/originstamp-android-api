package org.originstamp.originstampandroidclient;

import org.junit.Test;
import org.originstamp.originstampandroidclient.commons.HashResponseDTO;

import java.util.logging.Logger;

/**
 * Created by Thomas on 04.04.17.
 */
public class OriginStampAPITest {
    // logger
    private static final Logger LOGGER = Logger.getLogger(OriginStampAPITest.class.getSimpleName());

    @Test
    public void getHashInformation() throws Exception {
        // init rest request
        OriginStampAPI originStampAPI = new OriginStampAPI(
                "debbc938-b125-426a-bfa7-4ceb8486e976"
        );

        HashResponseDTO hashResponseDTO = originStampAPI.getHashInformation("308cd3761780e7251611a74a4023c89fce6ed8632be67d1f5ff32bb7d2337edb");

        LOGGER.info(hashResponseDTO.getHashString());

    }

}