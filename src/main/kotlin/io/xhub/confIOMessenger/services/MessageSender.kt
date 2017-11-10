package io.xhub.confIOMessenger.services

import io.vertx.core.Vertx
import io.vertx.core.buffer.Buffer
import io.vertx.core.http.HttpClientOptions
import io.xhub.confIOMessenger.config.config
import io.xhub.confIOMessenger.config.pageAccessToken
import org.slf4j.LoggerFactory

object MessageSender {
    val tokenAcces = config[pageAccessToken]
    val logger = LoggerFactory.getLogger(MessageSender::class.java)
    fun send(vertx:Vertx,message:String){
        logger.error(message)
               val client = vertx.createHttpClient(HttpClientOptions().setSsl(true).setLogActivity(true))
        val buffer: Buffer = Buffer.buffer()
       val request = client!!.post(443, "graph.facebook.com"
               , "/v2.6/me/messages?access_token=$tokenAcces",
                { response ->

                    println("message sent ${response.statusCode()}")
                })
        val buf =Buffer.buffer().apply {
            appendString(message)
        }
        request.putHeader("content-type", "application/json")
        request.putHeader("content-length", buf.length().toString())
        request.write(buf);
        request.end()
    }
}