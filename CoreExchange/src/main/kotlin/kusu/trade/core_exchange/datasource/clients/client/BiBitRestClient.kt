package kusu.trade.core_exchange.datasource.clients.client

import org.springframework.web.reactive.function.client.WebClient


class BiBitRestClient(){

    companion object{
        private val biBitClient: WebClient = WebClient
            .builder()
            .baseUrl("https://api-testnet.bybit.com")
            .build()

        fun getClient(): WebClient {

            return biBitClient
        }
    }
}
