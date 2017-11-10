package io.xhub.confIOMessenger

import io.vertx.core.AbstractVerticle
import io.vertx.core.http.HttpServer
import io.xhub.confIOMessenger.config.*
import io.xhub.confIOMessenger.config.host
import io.xhub.confIOMessenger.config.port

class RootVerticle: AbstractVerticle() {
    var server: HttpServer? = null

    override fun start() {
        server = vertx.createHttpServer()
        server?.requestHandler({ request ->
            val response = request.response()
            response.end("Hello world!")
        })

        server?.listen(config[port], config[host])

    }

    override fun stop() {
        server?.close()
    }
}