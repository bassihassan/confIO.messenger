package io.xhub.confIOMessenger.domain.modele

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import io.xhub.confIOMessenger.domain.Attachement

@JsonIgnoreProperties(ignoreUnknown = true)
sealed class Button {
    data class URL(
            val url: String,
            val title: String,
            val webview_height_ratio: String = "full",
            val messenger_extensions: Boolean = true,
            val fallback_url: String) : Button() {
        val type: String = "web_url"
    }

    data class PostBack(
            val title: String,
            val payload: String
    ) : Button() {
        val type: String = "postback"
    }

    data class Share(
            val share_content: Attachement
    ) : Button() {
        val type: String = "element_share"
    }

}