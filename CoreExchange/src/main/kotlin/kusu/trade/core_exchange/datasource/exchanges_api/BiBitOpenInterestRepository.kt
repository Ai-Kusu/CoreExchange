package kusu.trade.core_exchange.datasource.exchanges_api

import kusu.trade.core_exchange.consts.BiBitURLs
import kusu.trade.core_exchange.datamodels.bibit.exchange_response.open_interest.BiBitOpenInterestRequest
import kusu.trade.core_exchange.datamodels.bibit.exchange_response.open_interest.BiBitOpenInterestResponse
import org.springframework.http.HttpStatusCode
import org.springframework.web.reactive.function.client.WebClient

//@Component
class BiBitOpenInterestRepository(private val client: WebClient) {

    fun<T> getOpenInterest(t: T, category: String, symbol: String, intervalTime: String, limit: String): T {
        val response = client.get().uri("")
            .exchangeToMono { response ->
            if (response.statusCode() == HttpStatusCode.valueOf(200)){
                response.bodyToMono(kusu.trade.core_exchange.datamodels.bibit.exchange_response.open_interest.BiBitOpenInterestResponse::class.java).doOnNext { x ->
                    x
                }
            } else{
                throw Exception("BAD REQUEST ${response.statusCode()}")
            }
        }.block()

        if (response != null) {
            for (i in response.result.list)
                println(i)
        }

        return t
    }
}

fun main() {

    val request = kusu.trade.core_exchange.datamodels.bibit.exchange_response.open_interest.BiBitOpenInterestRequest(
        "linear",
        "BTCUSDT",
        "1d",
    )
    //BiBitOpenInterestRepository(BiBitRestClient.getClient()).getOpenInterest(request)
}