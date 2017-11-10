package io.xhub.confIOMessenger

import io.vertx.core.AbstractVerticle
import io.vertx.core.http.HttpServer
import io.xhub.confIOMessenger.config.*

class RootVerticle: AbstractVerticle() {
    var server: HttpServer? = null

    override fun start() {
        server = vertx.createHttpServer()
        server?.requestHandler{ request ->
            val response = request.response()
            val hubVerifyToken = request.getParam("hub.verify_token")
            val hubChallenge = request.getParam("hub.challenge")
            if(hubVerifyToken == config[verifyToken]) {
                response.end(hubChallenge)
            } else {
                response.end("Not Valid Token")
            }
        }

        server?.listen(config[port], config[host])

    }

    override fun stop() {
        server?.close()
    }
}