package org.originstamp.originstampandroidclient;

import android.support.v4.util.Pair;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by Thomas on 04.04.17.
 */
public class HashModelTest {
    // logger
    private static final Logger LOGGER = Logger.getLogger(HashModelTest.class.getSimpleName());

    @Test
    public void getSHA256() throws Exception {
        LOGGER.info("testing the hash service");
        List<Pair<String, String>> testData = new ArrayList<>();

        LOGGER.info("creating dummy data");
        testData.add(new Pair<>("thomas", "d38681074467c0bc147b17a9a12b9efa8cc10bcf545f5b0bccccf5a93c4a2b79"));
        testData.add(new Pair<>("originstamp", "716b4f08c3153fc30e1c40206cc804cbf3f65946ff37f0fd301ef4c2d9f58184"));
        testData.add(new Pair<>("R FDS FWgsS asDsd", "1867a0f5e6017685ed2032de44c685edec3b00d090426918042cdc3f129f7785"));
        testData.add(new Pair<>("", "e3b0c44298fc1c149afbf4c8996fb92427ae41e4649b934ca495991b7852b855"));
        testData.add(new Pair<>("nsdisadsaisdp asiao i809548 kldfi PISAUD)(1", "c56ad29fda1b8c5a5fb3d852876dde4fb2bcc495f7b59b0d784c0a7b69d512ef"));
        testData.add(new Pair<>("philip ehret stinkt :P", "398cd3761780e7251611a74a4023c89fce6ed8632be67d1f5ff32bb7d2337edb"));

        LOGGER.info("evaluating data and compare");
        // for each test data entry
        for (int i = 0; i < testData.size(); i++) {
            Pair pair = testData.get(i);
            String input = (String) pair.first;
            String output = (String) pair.second;

            // calc hash
            String hash = HashModel.getSHA256(input.getBytes());

            // must be identical
            Assert.assertEquals(hash, output);
        }

        LOGGER.info("test finished");
    }

}