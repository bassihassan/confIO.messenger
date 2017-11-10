package io.xhub.confIOMessenger.domain;

import java.io.Serializable;

public class AbstractMessageBody implements Serializable {
    private String mid;
    private String text;
    private Attachment attachment;

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Attachment getAttachment() {
        return attachment;
    }

    public void setAttachment(Attachment attachment) {
        this.attachment = attachment;
    }
}
