package io.xhub.confIOMessenger.domain

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import io.vertx.core.json.JsonObject
@JsonIgnoreProperties(ignoreUnknown = true)
data class Attachement(
        @JsonProperty("type")
        val type:String,
        @JsonProperty("payload")
        val payload:Map<String,Any>)