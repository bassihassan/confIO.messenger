package io.xhub.confIOMessenger.routes

import io.vertx.core.Handler
import io.vertx.ext.web.RoutingContext

class MessageHandler: Handler<RoutingContext> {
    override fun handle(event: RoutingContext) {
        val request = event.request()
        
    }
}