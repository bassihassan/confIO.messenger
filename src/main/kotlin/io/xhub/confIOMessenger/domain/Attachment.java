package io.xhub.confIOMessenger.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Attachment implements Serializable {
    private AttachmentType type;

    public enum AttachmentType {
        Image("image"),
        Audio("audio"),
        Video("video"),
        File("file"),
        Template("template");
        private String type;
        AttachmentType(final String type) {
            this.type = type;
        }
    }
}
