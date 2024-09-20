package kusu.trade.core_exchange.datasource.exchanges_api

import kusu.trade.core_exchange.consts.BingXURLs
import kusu.trade.core_exchange.datamodels.bingx.BingXRequest
import org.springframework.http.HttpStatusCode
import org.springframework.web.reactive.function.client.WebClient

//@Component
class BingXOpenInterestRepository(private val client: WebClient) {

    fun getOpenInterest(request: BingXRequest): String {
        val response = client.get().uri(BingXURLs.FUTURE_SYMBOLS)
            .exchangeToMono { response ->
            if (response.statusCode() == HttpStatusCode.valueOf(200)){
                response.bodyToMono(String::class.java).doOnNext { x ->
                    return@doOnNext
                }
            } else{
                throw Exception("BAD REQUEST ${response.statusCode()}")
            }
        }.block()

        return ""
    }
}

fun main() {

    //BingXOpenInterestRepository(BingXRestClient.getClient()).getOpenInterest(request)
}