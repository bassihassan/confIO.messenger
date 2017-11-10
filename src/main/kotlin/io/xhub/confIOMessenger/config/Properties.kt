@file:JvmName("Properties")

package io.xhub.confIOMessenger.config

import com.natpryce.konfig.*
import com.natpryce.konfig.ConfigurationProperties.Companion.systemProperties

val port by intType
val host by stringType

val config = systemProperties() overriding
        EnvironmentVariables() overriding
        ConfigurationProperties.fromResource("app.properties")
