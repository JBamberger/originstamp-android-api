package org.originstamp.originstampandroidclient.commons;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Copyright: Thomas Hepp, Inselgasse 11, 78462 Konstanz, 15.03.2017
 * All source code & each single commit is hashed and tamper proof timestamped with OriginStamp.org and proves the existence
 * of this code by this author. You are not allowed to sell / buy / modify / add / anything to this code without a permission of Thomas Hepp.
 * <p>
 */
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

        public Long getBlockDepth() {
            return blockDepth;
        }

        public void setBlockDepth(Long blockDepth) {
            this.blockDepth = blockDepth;
        }

        public String getSeedHash() {
            return seedHash;
        }

        public void setSeedHash(String seedHash) {
            this.seedHash = seedHash;
        }

        public Integer getSubmitStatus() {
            return submitStatus;
        }

        public void setSubmitStatus(Integer submitStatus) {
            this.submitStatus = submitStatus;
        }

        public Long getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(Long timestamp) {
            this.timestamp = timestamp;
        }

        public String getTransactionHash() {
            return transactionHash;
        }

        public void setTransactionHash(String transactionHash) {
            this.transactionHash = transactionHash;
        }

        public String getBitcoinAddress() {
            return bitcoinAddress;
        }

        public void setBitcoinAddress(String bitcoinAddress) {
            this.bitcoinAddress = bitcoinAddress;
        }

        public String getPublicKey() {
            return publicKey;
        }

        public void setPublicKey(String publicKey) {
            this.publicKey = publicKey;
        }
    }

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

        public Long getBlockDepth() {
            return blockDepth;
        }

        public void setBlockDepth(Long blockDepth) {
            this.blockDepth = blockDepth;
        }

        public String getSeedHash() {
            return seedHash;
        }

        public void setSeedHash(String seedHash) {
            this.seedHash = seedHash;
        }

        public Integer getSubmitStatus() {
            return submitStatus;
        }

        public void setSubmitStatus(Integer submitStatus) {
            this.submitStatus = submitStatus;
        }

        public Long getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(Long timestamp) {
            this.timestamp = timestamp;
        }

        public String getTransactionHash() {
            return transactionHash;
        }

        public void setTransactionHash(String transactionHash) {
            this.transactionHash = transactionHash;
        }

        public String getBitcoinAddress() {
            return bitcoinAddress;
        }

        public void setBitcoinAddress(String bitcoinAddress) {
            this.bitcoinAddress = bitcoinAddress;
        }

        public String getPublicKey() {
            return publicKey;
        }

        public void setPublicKey(String publicKey) {
            this.publicKey = publicKey;
        }
    }

    public static class Email implements Serializable {
        @JsonProperty("email_hash")
        private String emailHash;
        @JsonProperty("verified")
        private Integer verified;
        @JsonProperty("send_status")
        private Integer sendStatus;

        public String getEmailHash() {
            return emailHash;
        }

        public void setEmailHash(String emailHash) {
            this.emailHash = emailHash;
        }

        public Integer getVerified() {
            return verified;
        }

        public void setVerified(Integer verified) {
            this.verified = verified;
        }

        public Integer getSendStatus() {
            return sendStatus;
        }

        public void setSendStatus(Integer sendStatus) {
            this.sendStatus = sendStatus;
        }
    }

    public static class Twitter implements Serializable {
        @JsonProperty("tweet_id")
        private String tweetId;
        @JsonProperty("submit_status")
        private Integer submitStatus;

        public String getTweetId() {
            return tweetId;
        }

        public void setTweetId(String tweetId) {
            this.tweetId = tweetId;
        }

        public Integer getSubmitStatus() {
            return submitStatus;
        }

        public void setSubmitStatus(Integer submitStatus) {
            this.submitStatus = submitStatus;
        }
    }


    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Twitter getTwitter() {
        return twitter;
    }

    public void setTwitter(Twitter twitter) {
        this.twitter = twitter;
    }

    public String getUniqueUrl() {
        return uniqueUrl;
    }

    public void setUniqueUrl(String uniqueUrl) {
        this.uniqueUrl = uniqueUrl;
    }

    public String getHashString() {
        return hashString;
    }

    public void setHashString(String hashString) {
        this.hashString = hashString;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public Long getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Long dateCreated) {
        this.dateCreated = dateCreated;
    }

    public SingleSeed getSingleSeed() {
        return singleSeed;
    }

    public void setSingleSeed(SingleSeed singleSeed) {
        this.singleSeed = singleSeed;
    }

    public MultiSeed getMultiSeed() {
        return multiSeed;
    }

    public void setMultiSeed(MultiSeed multiSeed) {
        this.multiSeed = multiSeed;
    }

    public Boolean getCreated() {
        return created;
    }

    public void setCreated(Boolean created) {
        this.created = created;
    }
}
