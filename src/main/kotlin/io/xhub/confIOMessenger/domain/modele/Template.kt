package io.xhub.confIOMessenger.domain.modele

import io.xhub.confIOMessenger.annotation.IgnoreNotNullUnknown

sealed class Template {
    @IgnoreNotNullUnknown
    data class Generic(
            val elements: List<Element>?,
            val template_type: String = "generic"
    ) : Template() {

    }

    @IgnoreNotNullUnknown
    data class VList(
            val template_type: String = "list",
            val top_element_style:String= "compact",
            val elements: List<Element>?
    ) : Template() {

    }

}
