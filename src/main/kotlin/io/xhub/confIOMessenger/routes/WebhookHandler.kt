package io.xhub.confIOMessenger.routes

import io.vertx.core.Handler
import io.vertx.ext.web.RoutingContext
import io.xhub.confIOMessenger.config.config
import io.xhub.confIOMessenger.config.verifyToken

class WebhookHandler: Handler<RoutingContext> {
    override fun handle(event: RoutingContext) {
        val request = event.request()
        val response = request.response()
        val hubVerifyToken = request.getParam("hub.verify_token")
        val hubChallenge = request.getParam("hub.challenge")
        if(hubVerifyToken == config[verifyToken]) {
            response.end(hubChallenge)
        } else {
            response.end("Not Valid Token")
        }

    }
}