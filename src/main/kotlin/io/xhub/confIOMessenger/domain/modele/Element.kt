package io.xhub.confIOMessenger.domain.modele
import io.xhub.confIOMessenger.annotation.IgnoreNotNullUnknown

@IgnoreNotNullUnknown
data class Element(
    val title:String?="",
    val image_url:String?=null,
    val subtitle:String?=null,
    val default_action:Button?=null,
    val buttons:List<Button>?=null
)