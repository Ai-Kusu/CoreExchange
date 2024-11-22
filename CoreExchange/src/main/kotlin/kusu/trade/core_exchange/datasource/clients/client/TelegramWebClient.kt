package kusu.trade.core_exchange.datasource.clients.client

import kusu.trade.core_exchange.encryption.BingXAuthSignature.generateHmac256
import kusu.trade.core_exchange.encryption.BingXAuthSignature.getMessageToDigest
import org.springframework.http.HttpStatusCode
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.bodyToMono
import java.sql.Timestamp

class TelegramWebClient {
    private val bingXClient: WebClient = WebClient
        .builder()
        .baseUrl("http://localhost:8090")
        .build()

    fun postRequest(path : String, body: Any): String{

        val response = bingXClient
            .post()
            .uri(path)
            .bodyValue(body)
            .retrieve()
            .bodyToMono<String>()
            .block()

        return response!!
    }



    companion object{
        private val telegramWebClient = TelegramWebClient()

        fun getClient(): TelegramWebClient {

            return telegramWebClient
        }
    }
}