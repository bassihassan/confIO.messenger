package io.xhub.confIOMessenger.services

import io.vertx.core.AbstractVerticle
import io.vertx.core.eventbus.EventBus
import io.vertx.core.json.Json
import io.xhub.confIOMessenger.config.*
import io.xhub.confIOMessenger.domain.*
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class MessageHandler : AbstractVerticle() {
    val logger: Logger = LoggerFactory.getLogger(MessageHandler::class.java)
    var eventBus: EventBus? = null;
    override fun start() {
        logger.error("sender deployed")
        eventBus = vertx.eventBus();
        eventBus!!.consumer<String>("messageReceived", {
            val body = it.body();
            val request = Json.decodeValue(body, ReceivedRequest::class.java)
            val message = request.entry.filter {
                it.messaging != null || it.standby != null
            }.firstOrNull();
            message?.let {
                // From Input : Text Sended
                it.messaging?.let {
                    val message = it.filter { it.message?.text != null }.firstOrNull()
                    // if message not null
                    message?.let {
                        message.message?.quick_reply?.let {
                                logger.error("----quickReply---")
                                logger.error(message.toString())
                    //else
                        } ?: run {
                            logger.error("----- message ---")
                            logger.error(message.toString())
                            //Exemple Send QuickReply
//                            val responsemsg = SentRequest(message.sender,
//                                    Message.SentMessage("Get Started",
//                                            quick_replies =  listOf<QuickReply>(
//                                                    QuickReply("Venue","Venue"),
//                                                    QuickReply("FAQ","FAQ"),
//                                                    QuickReply("SCHEDULE","SCHEDULE"),
//                                                    QuickReply("SPEAKERS","SPEAKERS")
//                                            )))
                            // Exemple Send Attachement
                            val responsemsg = SentRequest(message.sender,Message.SentMessage(
                                    attachment = Attachement("image",
                                            mapOf(Pair("url","https://segunfamisa.com/img/kotlin-logo.png"),
                                                    Pair("is_reusable",true)
                                            )
                            )))
                            MessageSender.send(vertx, Json.encode(responsemsg))
                        }
                    }
                }
                // From Menu : Events Comming from Persistence Menu
                it.standby?.let {
                    //                    it.filter {it.postback !=null}.first()
                    logger.error("---- stand by ")
                    logger.error(it.toString())
                }

            }

        })

    }


    override fun stop() {
    }

}