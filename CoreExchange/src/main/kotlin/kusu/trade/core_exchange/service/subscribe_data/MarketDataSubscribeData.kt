package kusu.trade.core_exchange.service.subscribe_data

import kotlinx.coroutines.*
import kotlinx.serialization.Serializable
import kusu.trade.core_exchange.datasource.clients.client.BingXWebClient
import kusu.trade.core_exchange.datasource.clients.client.TelegramWebClient
import kusu.trade.core_exchange.datasource.exchange_data.MarkPriceKlineSource
import kusu.trade.core_exchange.datasource.exchange_data.OpenInterestSource
import kusu.trade.core_exchange.datasource.exchange_data.OrderBookSubscribe
import kusu.trade.core_exchange.service.console.ConsolePresentationKLine
import kusu.trade.core_exchange.service.console.ConsolePresentationOpenInterest
import kusu.trade.core_exchange.service.console.ConsolePresentationOrderBook

class MarketDataSubscribeData(
    private val bingXWebClient: BingXWebClient,
    private val telegramWebClient: TelegramWebClient,
    private var params: MutableMap<String, MutableMap<String, String>>
): SubscribeTokenData(bingXWebClient, params) {

    private var flag = true

    constructor(params: MutableMap<String, MutableMap<String, String>>) : this(
        bingXWebClient = BingXWebClient.getClient(),
        telegramWebClient = TelegramWebClient.getClient(),
        params = params
    )


    override suspend fun subscribe() {
       val openInterestSource = OpenInterestSource(bingXWebClient)
       val markPriceKlineSource = MarkPriceKlineSource(bingXWebClient)
       val orderBookSubscribe = OrderBookSubscribe(bingXWebClient)


        while (flag){

            val openInterest = openInterestSource.getNow(params = params["openInterestParams"]!!)
            val orderBook = orderBookSubscribe.getNow(params = params["markPriceKlineParas"]!!)
            val markPriceKline = markPriceKlineSource.getNow(params = params["orderBookParams"]!!)

            val r = ConsolePresentationKLine.dataToText(markPriceKline) +
                    "\n---------------------------------------------------------\n" +
                    ConsolePresentationOpenInterest.dataToText(openInterest) +
                    "\n---------------------------------------------------------\n" +
                    ConsolePresentationOrderBook.dataToText(orderBook)

            println(r)
            println("\n\n")

            telegramWebClient.postRequest("/", PostInfo("token", r))

            //delay(60000L) //1m
            delay(300000L) //5m

        }
    }

    override fun stopSubscribe() {
        flag = false
    }

    override fun continueSubscribe() {
        flag = true
    }

    override fun getParams(): MutableMap<String, MutableMap<String, String>> {
        return params
    }

    override fun setSourceParams(source: String, sourceParams: MutableMap<String, String>) {
        params[source] = sourceParams
    }

    override fun setParams(allParams: MutableMap<String, MutableMap<String, String>>) {
        params = allParams
    }


}

@Serializable
data class PostInfo(
    val token: String,
    val info: String
)

