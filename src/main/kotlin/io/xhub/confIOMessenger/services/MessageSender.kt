package io.xhub.confIOMessenger.services

import io.vertx.core.AbstractVerticle
import io.vertx.core.buffer.Buffer
import io.vertx.core.http.HttpClientResponse
import io.vertx.core.json.Json
import io.xhub.confIOMessenger.domain.Message
import io.xhub.confIOMessenger.config.*
import io.xhub.confIOMessenger.domain.SentMessage
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class MessageSender(val message: Message<SentMessage>) :AbstractVerticle() {
    val logger: Logger = LoggerFactory.getLogger(MessageSender::class.java)
    override fun start() {
        val messageString = Json.encode(message)
        val client = vertx.createHttpClient()
        val buffer: Buffer = Buffer.buffer()
        client.post(config[graphSendMessageURI].format(config[pageAccessToken]))
                .write(messageString)
                .handler { event: HttpClientResponse? ->
                    event?.bodyHandler{ b: Buffer? ->
                        buffer.appendBuffer(b)
                    }
                }
                .endHandler {
                    logger.debug(buffer.toString())
                }
    }



    override fun stop() {
    }

}