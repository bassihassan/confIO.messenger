@file:JvmName("Properties")

package io.xhub.confIOMessenger.config

import com.natpryce.konfig.*
import com.natpryce.konfig.ConfigurationProperties.Companion.systemProperties

val port by intType
val host by stringType
val verifyToken by stringType
val pageAccessToken by stringType
val graphSendMessageURI by stringType
val hostGraph by stringType
val uriGraph by stringType
val sslPort by intType

val config = systemProperties() overriding
        EnvironmentVariables() overriding
        ConfigurationProperties.fromResource("app.properties")
