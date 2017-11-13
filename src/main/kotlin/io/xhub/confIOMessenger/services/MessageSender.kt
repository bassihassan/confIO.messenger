package io.xhub.confIOMessenger.services

import io.vertx.core.Vertx
import io.vertx.core.buffer.Buffer
import io.vertx.core.http.HttpClientOptions
import io.xhub.confIOMessenger.config.*
import org.slf4j.LoggerFactory

object MessageSender {
    val tokenAcces = config[pageAccessToken]
    val host = config[hostGraph]
    val uri = config[uriGraph]
    val port = config[sslPort]
    val logger = LoggerFactory.getLogger(MessageSender::class.java)
    fun send(vertx: Vertx, message: String) {
        logger.error(message)
        val client = vertx.createHttpClient(HttpClientOptions().setSsl(true).setLogActivity(true))
        val buffer: Buffer = Buffer.buffer()
        val request = client!!.post(port, host
                , "$uri=$tokenAcces",
                { response ->

                    println("message sent ${response.statusCode()}")
                })
        val buf = Buffer.buffer().apply {
            appendString(message)
        }
        request.putHeader("content-type", "application/json")
        request.putHeader("content-length", buf.length().toString())
        request.write(buf);
        request.end()
    }
}