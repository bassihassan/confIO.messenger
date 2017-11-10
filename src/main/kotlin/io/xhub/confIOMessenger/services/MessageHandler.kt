package io.xhub.confIOMessenger.services

import io.vertx.core.AbstractVerticle
import io.vertx.core.eventbus.EventBus
import io.vertx.core.json.Json
import io.xhub.confIOMessenger.config.*
import io.xhub.confIOMessenger.domain.Message
import io.xhub.confIOMessenger.domain.ReceivedRequest
import io.xhub.confIOMessenger.domain.SentRequest
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class MessageHandler :AbstractVerticle() {
    val logger: Logger = LoggerFactory.getLogger(MessageHandler::class.java)
    var  eventBus:EventBus? = null;
    override fun start() {
        logger.error("sender deployed")
        eventBus = vertx.eventBus();
        eventBus!!.consumer<String>("messageReceived",  {
            val body = it.body();

            val request = Json.decodeValue(body, ReceivedRequest::class.java)
            val message = request.entry.flatMap {
               it.messaging
            }.filter { it.message != null && it.message.text != null }.first()
            val responsemsg = SentRequest(message.sender, Message("Hakko",null))

            MessageSender.send(vertx,Json.encode(responsemsg))

        })

    }



    override fun stop() {
    }

}