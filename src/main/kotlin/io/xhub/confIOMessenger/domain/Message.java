package io.xhub.confIOMessenger.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Message<T extends AbstractMessageBody> implements Serializable {
    @JsonProperty("messaging_type")
    private String messagingType;
    private Identifiable sender;
    private Identifiable recipient;
    private T message;
    private Long timestamp;

    public String getMessagingType() {
        return messagingType;
    }

    public void setMessagingType(String messagingType) {
        this.messagingType = messagingType;
    }

    public Identifiable getSender() {
        return sender;
    }

    public void setSender(Identifiable sender) {
        this.sender = sender;
    }

    public Identifiable getRecipient() {
        return recipient;
    }

    public void setRecipient(Identifiable recipient) {
        this.recipient = recipient;
    }

    public T getMessage() {
        return message;
    }

    public void setMessage(T message) {
        this.message = message;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }
}
