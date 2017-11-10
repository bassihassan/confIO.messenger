package io.xhub.confIOMessenger

import io.vertx.core.AbstractVerticle
import io.vertx.core.http.HttpServer
import io.vertx.ext.web.Router
import io.xhub.confIOMessenger.config.*
import io.xhub.confIOMessenger.routes.MessageHandler
import io.xhub.confIOMessenger.routes.WebhookHandler

class RootVerticle: AbstractVerticle() {
    var server: HttpServer? = null
    var webhookHandler: WebhookHandler? = null
    var messageHandler: MessageHandler? = null
    override fun start() {
        server = vertx.createHttpServer()
        webhookHandler = WebhookHandler()
        messageHandler = MessageHandler(vertx)
        val router = Router.router(vertx)
        router.get().handler(webhookHandler)
        router.post().handler(messageHandler)
        server?.requestHandler { router.accept(it) }
        server?.listen(config[port], config[host])

    }

    override fun stop() {
        server?.close()
    }
}