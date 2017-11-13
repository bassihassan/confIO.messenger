package io.xhub.confIOMessenger.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import io.xhub.confIOMessenger.annotation.IgnoreNotNullUnknown

@IgnoreNotNullUnknown
data class SentRequest(
        @JsonProperty("recipient")
        val recipient:Identifier,
        @JsonProperty("message")
        val message: Message
)