package io.xhub.confIOMessenger.annotation

import com.fasterxml.jackson.annotation.JacksonAnnotationsInside
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import java.lang.annotation.RetentionPolicy

@Retention(AnnotationRetention.RUNTIME)
@JacksonAnnotationsInside
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
annotation class IgnoreNotNullUnknown