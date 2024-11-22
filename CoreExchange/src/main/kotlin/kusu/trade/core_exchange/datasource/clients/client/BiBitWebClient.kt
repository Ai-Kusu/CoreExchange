package kusu.trade.core_exchange.datasource.clients.client

import kusu.trade.core_exchange.consts.BiBitURLs
import org.springframework.web.reactive.function.client.WebClient


class BiBitWebClient(){

    companion object{
        private val biBitClient: WebClient = WebClient
            .builder()
            .baseUrl(BiBitURLs.URL_API)
            .build()

        fun getClient(): WebClient {

            return biBitClient
        }
    }
}
