package io.xhub.confIOMessenger.routes

import com.fasterxml.jackson.core.type.TypeReference
import io.vertx.core.Handler
import io.vertx.core.Vertx
import io.vertx.core.json.Json
import io.vertx.ext.web.RoutingContext
import io.xhub.confIOMessenger.domain.Message
import io.xhub.confIOMessenger.domain.ReceivedMessage
import io.xhub.confIOMessenger.domain.SentMessage
import io.xhub.confIOMessenger.services.MessageSender
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class MessageHandler(val vertx: Vertx): Handler<RoutingContext> {
    val logger: Logger = LoggerFactory.getLogger(MessageHandler::class.java)
    override fun handle(event: RoutingContext) {

        event.request().bodyHandler { body ->
            logger.error("---------------------------------------")
            logger.error(body.toString("utf-8"))
            val message = Json.decodeValue(body.toString("utf-8"), object : TypeReference<Message<ReceivedMessage>>() {})
            val messageToSend = Message<SentMessage>()
            val messageBody = SentMessage()

            messageToSend.sender = message.recipient
            messageToSend.recipient = message.sender
            messageBody.text = message.message.text
            messageToSend.message = messageBody

            val senderVerticle = MessageSender(messageToSend)

            vertx.deployVerticle(senderVerticle)
        }

    }
}