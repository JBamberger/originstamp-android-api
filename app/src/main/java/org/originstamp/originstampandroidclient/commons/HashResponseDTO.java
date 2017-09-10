package org.originstamp.originstampandroidclient.commons;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * Copyright: Thomas Hepp, Inselgasse 11, 78462 Konstanz, 15.03.2017
 * All source code & each single commit is hashed and tamper proof timestamped with OriginStamp.org and proves the existence
 * of this code by this author. You are not allowed to sell / buy / modify / add / anything to this code without a permission of Thomas Hepp.
 * <p>
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class HashResponseDTO implements Serializable {
    @JsonProperty("comment")
    private String comment;
    @JsonProperty("twitter")
    private Twitter twitter;
    @JsonProperty("unique_url")
    private String uniqueUrl;
    @JsonProperty("hash_string")
    private String hashString;
    @JsonProperty("email")
    private Email email;
    @JsonProperty("date_created")
    private Long dateCreated;
    @JsonProperty("single_seed")
    private SingleSeed singleSeed;
    @JsonProperty("multi_seed")
    private MultiSeed multiSeed;
    @JsonProperty("created")
    private Boolean created;

    /**
     * Single Seed class
     * contains the information for single seeds. Single Seeds are directly submitted hashes to the blockchain.
     * private key = hash string
     */
    public static class SingleSeed implements Serializable {
        @JsonProperty("block_depth")
        private Long blockDepth;
        @JsonProperty("seed_hash")
        private String seedHash;
        @JsonProperty("submit_status")
        private Integer submitStatus;
        @JsonProperty("timestamp")
        private Long timestamp;
        @JsonProperty("tx_hash")
        private String transactionHash;
        @JsonProperty("btc_address")
        private String bitcoinAddress;
        @JsonProperty("pub_key")
        private String publicKey;

        /**
         * returns the block depth of the transaction containing the requested hash
         * @return
         */
        public Long getBlockDepth() {
            return blockDepth;
        }

        public void setBlockDepth(Long blockDepth) {
            this.blockDepth = blockDepth;
        }

        /**
         * seed hash which is used as private key for the address generation
         * @return
         */
        public String getSeedHash() {
            return seedHash;
        }

        public void setSeedHash(String seedHash) {
            this.seedHash = seedHash;
        }

        /**
         * the submit status of the transaction
         * 0: submitted to OriginStamp
         * 1: submitted to the bitcoin network
         * 2: transaction included in the latest block
         * 3: transaction is included and at least there is one block above
         * @return
         */
        public Integer getSubmitStatus() {
            return submitStatus;
        }

        public void setSubmitStatus(Integer submitStatus) {
            this.submitStatus = submitStatus;
        }

        /**
         * returns the unix epoch timestamp in milliseconds
         * @return
         */
        public Long getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(Long timestamp) {
            this.timestamp = timestamp;
        }

        /**
         * gets the hash of the transaction which can be verified on blockchain.info e.g.
         * https://blockchain.info/tx/d2cb30ddae11670f4f8173a4d12e6f40f9c095ddec59776b3614534c9797724d
         * @return
         */
        public String getTransactionHash() {
            return transactionHash;
        }

        public void setTransactionHash(String transactionHash) {
            this.transactionHash = transactionHash;
        }

        /**
         * returns the bitcoin address in base 58 encoding. the first transaction to this bitcoin
         * address represents the timestamp for a given private key
         * @return
         */
        public String getBitcoinAddress() {
            return bitcoinAddress;
        }

        public void setBitcoinAddress(String bitcoinAddress) {
            this.bitcoinAddress = bitcoinAddress;
        }

        /**
         * public key which is actually a point on a elliptic curve
         * @return
         */
        public String getPublicKey() {
            return publicKey;
        }

        public void setPublicKey(String publicKey) {
            this.publicKey = publicKey;
        }
    }

    /**
     * Multi seed information
     * is the default operation based on the scheduler batch jobs, which submits all hashes
     * once a day
     */
    public static class MultiSeed implements Serializable {
        @JsonProperty("block_depth")
        private Long blockDepth;
        @JsonProperty("seed_hash")
        private String seedHash;
        @JsonProperty("submit_status")
        private Integer submitStatus;
        @JsonProperty("timestamp")
        private Long timestamp;
        @JsonProperty("tx_hash")
        private String transactionHash;
        @JsonProperty("btc_address")
        private String bitcoinAddress;
        @JsonProperty("pub_key")
        private String publicKey;

        /**
         * returns the block depth of the transaction containing the requested hash
         * @return
         */
        public Long getBlockDepth() {
            return blockDepth;
        }

        public void setBlockDepth(Long blockDepth) {
            this.blockDepth = blockDepth;
        }

        /**
         * seed hash which is used as private key for the address generation
         * @return
         */
        public String getSeedHash() {
            return seedHash;
        }

        public void setSeedHash(String seedHash) {
            this.seedHash = seedHash;
        }

        /**
         * the submit status of the transaction
         * 0: submitted to OriginStamp
         * 1: submitted to the bitcoin network
         * 2: transaction included in the latest block
         * 3: transaction is included and at least there is one block above
         * @return
         */
        public Integer getSubmitStatus() {
            return submitStatus;
        }

        public void setSubmitStatus(Integer submitStatus) {
            this.submitStatus = submitStatus;
        }

        /**
         * returns the unix epoch timestamp in milliseconds
         * @return
         */
        public Long getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(Long timestamp) {
            this.timestamp = timestamp;
        }

        /**
         * gets the hash of the transaction which can be verified on blockchain.info e.g.
         * https://blockchain.info/tx/d2cb30ddae11670f4f8173a4d12e6f40f9c095ddec59776b3614534c9797724d
         * @return
         */
        public String getTransactionHash() {
            return transactionHash;
        }

        public void setTransactionHash(String transactionHash) {
            this.transactionHash = transactionHash;
        }

        /**
         * returns the bitcoin address in base 58 encoding. the first transaction to this bitcoin
         * address represents the timestamp for a given private key
         * @return
         */
        public String getBitcoinAddress() {
            return bitcoinAddress;
        }

        public void setBitcoinAddress(String bitcoinAddress) {
            this.bitcoinAddress = bitcoinAddress;
        }

        /**
         * public key which is actually a point on a elliptic curve
         * @return
         */
        public String getPublicKey() {
            return publicKey;
        }

        public void setPublicKey(String publicKey) {
            this.publicKey = publicKey;
        }
    }

    /**
     * contains mail information
     */
    public static class Email implements Serializable {
        @JsonProperty("email_hash")
        private String emailHash;
        @JsonProperty("verified")
        private Integer verified;
        @JsonProperty("send_status")
        private Integer sendStatus;

        /**
         * returns the sha256 of the mail address which is linked to the submitted hash
         * @return
         */
        public String getEmailHash() {
            return emailHash;
        }

        public void setEmailHash(String emailHash) {
            this.emailHash = emailHash;
        }

        /**
         * returns whether the email is verified or not
         * @return
         */
        public Integer getVerified() {
            return verified;
        }

        public void setVerified(Integer verified) {
            this.verified = verified;
        }

        /**
         * mail status
         *
         * int STATUS_PENDING = 0;
         * Email is not verified yet. After 7 days, the system sets the status to cancelled
         * int STATUS_VERIFIED = 1;
         * The email address was verified and the user receives notifications about the submit status
         * int STATUS_CANCELLED = 2;
         * After 7 days of pending the status is automatically set to cancelled
         * int STATUS_UNSUBSCRIBED = 3;
         * The user does not get any notifications
         * @return
         */
        public Integer getSendStatus() {
            return sendStatus;
        }

        public void setSendStatus(Integer sendStatus) {
            this.sendStatus = sendStatus;
        }
    }

    /**
     * contains twitter informatiom
     */
    public static class Twitter implements Serializable {
        @JsonProperty("tweet_id")
        private String tweetId;
        @JsonProperty("submit_status")
        private Integer submitStatus;

        /**
         * returns the twitter id
         * @return
         */
        public String getTweetId() {
            return tweetId;
        }

        public void setTweetId(String tweetId) {
            this.tweetId = tweetId;
        }

        /**
         * submit status of the tweet
         * 0: unsubmitted
         * 1: submitted
         * @return
         */
        public Integer getSubmitStatus() {
            return submitStatus;
        }

        public void setSubmitStatus(Integer submitStatus) {
            this.submitStatus = submitStatus;
        }
    }

    /**
     * returns the comment / title which is public accessible
     * @return
     */
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * returns the twitter information
     * @return
     */
    public Twitter getTwitter() {
        return twitter;
    }

    public void setTwitter(Twitter twitter) {
        this.twitter = twitter;
    }

    /**
     * returns the unique url for the publication feature
     * @return
     */
    public String getUniqueUrl() {
        return uniqueUrl;
    }

    public void setUniqueUrl(String uniqueUrl) {
        this.uniqueUrl = uniqueUrl;
    }

    /**
     * returns the hash string which was requested
     * @return
     */
    public String getHashString() {
        return hashString;
    }

    public void setHashString(String hashString) {
        this.hashString = hashString;
    }

    /**
     * returning the mail information
     * @return
     */
    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    /**
     * unix epoch in milliseconds representing the date when the hash was submitted to OriginStamp
     * @return
     */
    public Long getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Long dateCreated) {
        this.dateCreated = dateCreated;
    }

    /**
     * returns the single seed information
     * @return
     */
    public SingleSeed getSingleSeed() {
        return singleSeed;
    }

    public void setSingleSeed(SingleSeed singleSeed) {
        this.singleSeed = singleSeed;
    }

    /**
     * returns multi seed information
     * @return
     */
    public MultiSeed getMultiSeed() {
        return multiSeed;
    }

    public void setMultiSeed(MultiSeed multiSeed) {
        this.multiSeed = multiSeed;
    }

    /**
     * true: hash is newly created
     * false: hash already exists on OriginStamp
     * @return
     */
    public Boolean getCreated() {
        return created;
    }

    public void setCreated(Boolean created) {
        this.created = created;
    }
}
