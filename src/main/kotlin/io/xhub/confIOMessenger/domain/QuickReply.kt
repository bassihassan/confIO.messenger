package io.xhub.confIOMessenger.domain

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.core.util.RequestPayload

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class  QuickReply constructor(
        @JsonProperty("payload")
        val payload: String?,
        @JsonProperty("title")
        val title:String?=null,
        @JsonProperty("content_type")
        val content_type:String?="text",
        @JsonProperty("image_url")
        val image_url:String?=null

)