package kusu.trade.core_exchange.datasource.clients.ws

import kusu.trade.core_exchange.encryption.GZip.decodeGzip
import org.java_websocket.client.WebSocketClient
import org.java_websocket.handshake.ServerHandshake
import java.io.IOException
import java.net.URI
import java.nio.ByteBuffer


object WebSocketExample {
    private const val PATH =
        "wss://open-api-swap.bingx.com/swap-market?listenKey=425f783f4a17cd65f4a5d7470cfd45a956dba0c29564aa4b70967bee4e4a8984"
    private const val CHANNEL = "{\"id\":\"e745cd6d-d0f6-4a70-8d5a-043e4c741b40\",\"reqType\": \"sub\",\"dataType\":\"SUI-USDT@kline_1h\"}"
    private lateinit var webSocketClient: WebSocketClient

    @JvmStatic
    fun main(args: Array<String>) {
        try {
            // Initialize WebSocket client
            val uri = URI(PATH)
            webSocketClient = object : WebSocketClient(uri) {
                override fun onOpen(handshakedata: ServerHandshake) {
                    println("WebSocket connection opened")
                    send(CHANNEL)
                }

                override fun onMessage(message: String) {
                    println("Received Text Message: $message")
                }

                override fun onMessage(bytes: ByteBuffer) {
                    try {

                        println(bytes)
                        val decodedMsg = decodeGzip(bytes.array())
                        println("Received Binary Message: $decodedMsg")

                        if ("Ping" == decodedMsg) {
                            send("Pong");
                            println("Sent Pong");
                        }

                    } catch (e: IOException) {
                        println("Error decoding message: " + e.message)
                    }
                }

                override fun onClose(code: Int, reason: String, remote: Boolean) {
                    println("WebSocket connection closed: $reason")
                }

                override fun onError(ex: Exception) {
                    println("WebSocket error: " + ex.message)
                }
            }

            webSocketClient.connectBlocking()

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

}
