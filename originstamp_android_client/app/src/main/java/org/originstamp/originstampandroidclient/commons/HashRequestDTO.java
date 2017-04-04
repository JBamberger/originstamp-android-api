package org.originstamp.originstampandroidclient.commons;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Copyright: Thomas Hepp, Inselgasse 11, 78462 Konstanz, 15.03.2017
 * All source code & each single commit is hashed and tamper proof timestamped with OriginStamp.org and proves the existence
 * of this code by this author. You are not allowed to sell / buy / modify / add / anything to this code without a permission of Thomas Hepp.
 * <p>
 */
public class HashRequestDTO implements Serializable {
    @JsonProperty("url")
    private String url;
    @JsonProperty("email")
    private String email;
    @JsonProperty("comment")
    private String comment;
    @JsonProperty("submit_ops")
    private String[] submitOperations;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String[] getSubmitOperations() {
        return submitOperations;
    }

    public void setSubmitOperations(String[] submitOperations) {
        this.submitOperations = submitOperations;
    }
}