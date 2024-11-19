package kusu.trade.core_exchange.datasource.clients.ws

import com.fasterxml.jackson.databind.ObjectMapper
import kusu.trade.core_exchange.consts.BingXURLs
import kusu.trade.core_exchange.encryption.GZip.decodeGzip
import org.reactivestreams.Publisher
import org.springframework.web.reactive.socket.WebSocketMessage
import org.springframework.web.reactive.socket.WebSocketSession
import org.springframework.web.reactive.socket.client.ReactorNettyWebSocketClient
import org.springframework.web.reactive.socket.client.WebSocketClient
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.toMono
import java.io.IOException
import java.net.URI
import java.nio.ByteBuffer

class BingXWSClient {

    fun createBingXWsClient(path: String, unit: (input: String) -> Unit) {

        val client: WebSocketClient = ReactorNettyWebSocketClient()


        client.execute(
            URI.create(BingXURLs.WS_API_URL)
        ) { session ->
            val subscribeRequest: MutableMap<String, Any> = HashMap()

            val objectMapper = ObjectMapper()
            val subscribeMessage: String = objectMapper.writeValueAsString(subscribeRequest)

            var answer = ""
            println(subscribeMessage)

            session.send(
                Flux.just(session.textMessage(path))
            ).then(
                session.receive()
                    .map(WebSocketMessage::getPayload).doOnNext { x ->
                        try {

                            answer = decodeGzip(x.asInputStream().readAllBytes())

                            if ("Ping" == answer){
                                println("Ping")
                            } else {
                                unit(answer)
                            }

                        } catch (e: Exception){
                            println(x)
                        }
                    }.doOnNext {
                        if ("Ping" == answer) {
                            sendPong(session)
                            println("Pong")
                        }
                    }.then()
            )

        }.block()

        println("t")
    }

    private fun sendPong(session : WebSocketSession): Mono<Void?> =
        session.send {
            Mono.just(session.textMessage("Pong"))
        }

}

fun main() {
    val CHANNEL = "{\"id\":\"e745cd6d-d0f6-4a70-8d5a-043e4c741b40\",\"reqType\": \"sub\",\"dataType\":\"SUI-USDT@kline_1h\"}"

    BingXWSClient().createBingXWsClient(
        CHANNEL,
        ::println
    )

}

fun print(x: String): Unit {
    println(x)
}