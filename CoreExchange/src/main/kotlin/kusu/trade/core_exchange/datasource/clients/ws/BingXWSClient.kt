package kusu.trade.core_exchange.datasource.clients.ws

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.web.reactive.socket.WebSocketMessage
import org.springframework.web.reactive.socket.client.ReactorNettyWebSocketClient
import org.springframework.web.reactive.socket.client.WebSocketClient
import reactor.core.publisher.Flux
import java.net.URI
import java.util.HashMap

class BingXWSClient {

    fun createBingXWsClient(path: String, args: List<String>, unit: (input: String) -> Unit) {

        val client: WebSocketClient = ReactorNettyWebSocketClient()


        client.execute(
            URI.create("wss://stream.bybit.com/$path")
        ) { session ->
            val subscribeRequest: MutableMap<String, Any> = HashMap()
            subscribeRequest["op"] = "subscribe"
            subscribeRequest["args"] = args

            val objectMapper = ObjectMapper()
            val subscribeMessage: String = objectMapper.writeValueAsString(subscribeRequest)

            println(subscribeMessage)
            session.send(
                Flux.just(session.textMessage(subscribeMessage))

            ).then(
                session.receive()
                    .map(WebSocketMessage::getPayloadAsText).doOnNext { x ->
                        try {
                            unit(x)
                        } catch (e: Exception){

                            println(x)
                        }
                    }.then()
            )

        }.block()
    }


}