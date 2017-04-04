package org.originstamp.originstampandroidclient;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Thomas on 04.04.17.
 */

class HashModel {
    /**
     * converts a byte array to its hex string representation
     *
     * @param pBytes
     * @return
     */
    private String convertToHex(byte[] pBytes) {
        // init string buffer
        StringBuffer hexString = new StringBuffer();

        // for each byte
        for (int i = 0; i < pBytes.length; i++) {
            String hex = Integer.toHexString(0xff & pBytes[i]);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }

        // return the string
        return hexString.toString();
    }

    /**
     * calculates the SHA256 hash from a byte array and returns it in HEX
     *
     * @param pBytes
     * @return
     */
    public String getSHA256(byte[] pBytes) throws NoSuchAlgorithmException {
        MessageDigest sha = MessageDigest.getInstance("SHA-256");
        sha.update(pBytes);

        // create sha 256
        byte[] digest = sha.digest();
        // return hex string
        return convertToHex(digest);
    }
}
