package io.xhub.confIOMessenger.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class QuickReply {
    @JsonProperty("content_type")
    private String contenType;
    private String title;
    @JsonProperty("image_url")
    private String imageUrl;
    private String payload;

    public String getContenType() {
        return contenType;
    }

    public void setContenType(String contenType) {
        this.contenType = contenType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }
}
