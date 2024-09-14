package kusu.trade.core_exchange.datasource.exchanges_api.open_interest

import kusu.trade.core_exchange.consts.BiBitURLs
import kusu.trade.core_exchange.datamodels.open_interest.BiBitOpenInterestRequest
import kusu.trade.core_exchange.datamodels.open_interest.BiBitOpenInterestResponse
import org.springframework.http.HttpStatusCode
import org.springframework.web.reactive.function.client.WebClient

//@Component
class BiBitOpenInterestRepository(private val client: WebClient) {

    fun getOpenInterest(category: String, symbol: String, intervalTime: String, limit: String): Unit {
        val response = client.get().uri(BiBitURLs.openInterest +"?category=linear&symbol=BTCUSDT&intervalTime=1h")
            .exchangeToMono { response ->
            if (response.statusCode() == HttpStatusCode.valueOf(200)){
                response.bodyToMono(BiBitOpenInterestResponse::class.java).doOnNext { x ->
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
    }
}

fun main() {

    val request = BiBitOpenInterestRequest(
        "linear",
        "BTCUSDT",
        "1d",
    )
    //BiBitOpenInterestRepository(BiBitRestClient.getClient()).getOpenInterest(request)
}