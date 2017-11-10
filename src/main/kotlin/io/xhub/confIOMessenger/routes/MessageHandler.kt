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

class MessageHandler(val vertx: Vertx): Handler<RoutingContext> {
    override fun handle(event: RoutingContext) {
        val message = Json.decodeValue(event.bodyAsString, object : TypeReference<Message<ReceivedMessage>>() {})
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