package org.originstamp.originstampandroidclient;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by Thomas on 04.04.17.
 */
public class HashModelTest {

    @Test
    public void getSHA256() throws Exception {
        assertEquals(HashModel.getSHA256("thomas".getBytes()), "d38681074467c0bc147b17a9a12b9efa8cc10bcf545f5b0bccccf5a93c4a2b79");
        assertEquals(HashModel.getSHA256("originstamp".getBytes()), "716b4f08c3153fc30e1c40206cc804cbf3f65946ff37f0fd301ef4c2d9f58184");
        assertEquals(HashModel.getSHA256("R FDS FWgsS asDsd".getBytes()), "1867a0f5e6017685ed2032de44c685edec3b00d090426918042cdc3f129f7785");
        assertEquals(HashModel.getSHA256("".getBytes()), "e3b0c44298fc1c149afbf4c8996fb92427ae41e4649b934ca495991b7852b855");
        assertEquals(HashModel.getSHA256("nsdisadsaisdp asiao i809548 kldfi PISAUD)(1".getBytes()), "c56ad29fda1b8c5a5fb3d852876dde4fb2bcc495f7b59b0d784c0a7b69d512ef");
        assertEquals(HashModel.getSHA256("philip ehret stinkt :P".getBytes()), "398cd3761780e7251611a74a4023c89fce6ed8632be67d1f5ff32bb7d2337edb");
    }

}