package io.xhub.confIOMessenger

import io.vertx.core.AbstractVerticle
import io.vertx.core.http.HttpServer
import io.vertx.ext.web.Router
import io.xhub.confIOMessenger.config.*
import io.xhub.confIOMessenger.routes.PostsHandler
import io.xhub.confIOMessenger.routes.WebhookHandler
import io.xhub.confIOMessenger.services.MessageHandler
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class RootVerticle: AbstractVerticle() {
    val logger: Logger = LoggerFactory.getLogger(RootVerticle::class.java)
    var server: HttpServer? = null
    var webhookHandler: WebhookHandler? = null
    var postsHandler: PostsHandler? = null
    override fun start() {
        logger.error("root")
        server = vertx.createHttpServer()
        //WebHook Handler
        webhookHandler = WebhookHandler()
        //Post Message Handler
        postsHandler = PostsHandler()
        val router = Router.router(vertx)
        router.get().handler(webhookHandler)
        router.post().handler(postsHandler)
        server?.requestHandler { router.accept(it) }
        server?.listen(config[port], config[host])
        vertx.deployVerticle(MessageHandler())

    }

    override fun stop() {
        server?.close()
    }
}