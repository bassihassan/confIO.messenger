package io.xhub.confIOMessenger.domain

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import io.vertx.core.json.JsonObject
import io.xhub.confIOMessenger.annotation.IgnoreNotNullUnknown

@IgnoreNotNullUnknown
data class Attachement(
        @JsonProperty("type")
        val type: String,
        @JsonProperty("payload")
        val payload: Any)

enum class AttachementType {
    template, image, video
}
