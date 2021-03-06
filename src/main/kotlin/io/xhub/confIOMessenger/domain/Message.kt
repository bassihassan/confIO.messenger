package io.xhub.confIOMessenger.domain

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.node.BooleanNode
import io.vertx.core.json.JsonObject
import io.xhub.confIOMessenger.annotation.IgnoreNotNullUnknown

@IgnoreNotNullUnknown
sealed class Message(
        @JsonProperty()
        open val text:String?=null,
        @JsonProperty("is_echo")
        val is_echo:Boolean?= null
){
    @IgnoreNotNullUnknown
    data  class ReceivedMessage(
            @JsonProperty("text")
            override var  text:String?=null,
            @JsonProperty("attachments")
            val attachments:List<Attachement>?=null,
            @JsonProperty("quick_reply")
            val quick_reply:QuickReply?=null
    ) :Message(text)
    @IgnoreNotNullUnknown
    data class SentMessage(
            @JsonProperty("text")
            override var text:String?=null,
            @JsonProperty("attachment")
            val attachment:Attachement?=null,
            @JsonProperty("quick_replies")
            val quick_replies:List<QuickReply>?= null
    ):Message(text)
}
