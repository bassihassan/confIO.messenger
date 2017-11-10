package io.xhub.confIOMessenger.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonIgnoreProperties(ignoreUnknown = true)
public class ReceivedMessage extends AbstractMessageBody {
    @JsonProperty("quick_reply")
    private QuickReply quickReply;

    public QuickReply getQuickReply() {
        return quickReply;
    }

    public void setQuickReply(QuickReply quickReply) {
        this.quickReply = quickReply;
    }
}
