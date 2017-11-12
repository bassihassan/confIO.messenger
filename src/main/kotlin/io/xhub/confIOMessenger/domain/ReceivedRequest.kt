package io.xhub.confIOMessenger.domain

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
@JsonIgnoreProperties(ignoreUnknown = true)
data class ReceivedRequest(
        @JsonProperty("object")
        val obj:String,
        @JsonProperty("entry")
        val entry: List<Entry>
)
@JsonIgnoreProperties(ignoreUnknown = true)
data class Entry(
        @JsonProperty("id")
        val id:String,
        @JsonProperty("messaging")
        val messaging:List<Messaging>?,
        @JsonProperty("standby")
        val standby: List<Standby>?
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class Messaging(
        @JsonProperty("sender")
        val sender:Identifier,
        @JsonProperty("recipient")
        val recipient:Identifier,
        @JsonProperty("message")
        val message:Message.ReceivedMessage?
)
@JsonIgnoreProperties(ignoreUnknown = true)
data class Standby(
        @JsonProperty("sender")
        val sender:Identifier,
        @JsonProperty("recipient")
        val recipient: Identifier,
        @JsonProperty("postback")
        val postback:Map<String,String>
)
