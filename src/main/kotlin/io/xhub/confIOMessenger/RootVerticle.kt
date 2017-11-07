package io.xhub.confIOMessenger

import io.vertx.core.AbstractVerticle
import io.vertx.core.http.HttpServer

class RootVerticle: AbstractVerticle() {
    var server: HttpServer? = null

    override fun start() {
        server = vertx.createHttpServer()
        server?.requestHandler({ request ->
            val response = request.response()
            response.end("Hello world!")
        })

        server?.listen(8080)

    }

    override fun stop() {
        server?.close()
    }
}