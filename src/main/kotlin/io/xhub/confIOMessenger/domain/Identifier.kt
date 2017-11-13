package io.xhub.confIOMessenger.domain

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import io.xhub.confIOMessenger.annotation.IgnoreNotNullUnknown

@IgnoreNotNullUnknown
data class Identifier(
        @JsonProperty("id")
        val id:String
)