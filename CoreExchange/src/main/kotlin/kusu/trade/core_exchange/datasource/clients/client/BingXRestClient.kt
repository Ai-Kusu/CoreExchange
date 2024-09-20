package kusu.trade.core_exchange.datasource.clients.client

import kusu.trade.core_exchange.consts.BingXURLs
import org.springframework.web.reactive.function.client.WebClient

class BingXRestClient {
    companion object{
        private val bingXClient: WebClient = WebClient
            .builder()
            .baseUrl(BingXURLs.API_URL)
            .build()

        fun getClient(): WebClient {

            return bingXClient
        }
    }
}