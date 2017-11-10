package io.xhub.confIOMessenger.routes

import io.netty.handler.codec.http.HttpResponseStatus
import io.vertx.core.Handler
import io.vertx.ext.web.RoutingContext
import io.vertx.kotlin.lang.setStatusCode
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class PostsHandler : Handler<RoutingContext> {
    val logger: Logger = LoggerFactory.getLogger(PostsHandler::class.java)
    override fun handle(event: RoutingContext) {
        val eventBus = event.vertx().eventBus();
        event.request().bodyHandler { body ->
            val obj = body.toJsonObject()
            eventBus.send("messageReceived",body.toString())
        }.response().setStatusCode(HttpResponseStatus.OK).end()
    }
}