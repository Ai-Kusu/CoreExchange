package kusu.trade.core_exchange.datasource.exchange_data

import kotlinx.coroutines.flow.flow
import kotlinx.serialization.json.Json
import kusu.trade.core_exchange.consts.BingXURLs
import kusu.trade.core_exchange.datamodels.bingx.BingXResponseBase
import kusu.trade.core_exchange.datamodels.bingx.open_interest.BingXResponseOpenInterest
import kusu.trade.core_exchange.datamodels.bingx.order_book.BingXResponseOrderBook
import kusu.trade.core_exchange.datasource.clients.client.BingXWebClient
import java.text.DecimalFormat
import java.util.*


class OrderBookSubscribe(private val bingXWebClient: BingXWebClient = BingXWebClient.getClient()) {

    fun subscribe(symbol: String) = flow{
        val params = TreeMap<String,String>()
        params["symbol"] = symbol
        params["limit"] = "500";

        while (true){
            val response = bingXWebClient.getRequest(
                BingXURLs.ORDER_BOOK,
                params
            )

            val jsonR = Json.decodeFromString<BingXResponseBase<BingXResponseOrderBook>>(response)

            emit(jsonR)

            kotlinx.coroutines.delay(30000)
        }
    }

    suspend fun get(symbol: String): BingXResponseBase<BingXResponseOpenInterest> {
        val params = TreeMap<String,String>()
        params["symbol"] = symbol

        val response = bingXWebClient.getRequest(
            BingXURLs.ORDER_BOOK,
            params
        )

        val jsonR = Json.decodeFromString<BingXResponseBase<BingXResponseOpenInterest>>(response)

        return(jsonR)

    }
}

suspend fun main() {
    OrderBookSubscribe().subscribe("NEIROETH-USDT").collect{ x ->
        val d = x.data

        val df = DecimalFormat("#.##")

        val sumA: Double = d.asks.fold(0.0) { sum, element -> sum + element[1].toDouble() }
        val sumB: Double = d.bids.fold(0.0) { sum, element -> sum + element[1].toDouble() }

        println("--------------------------- ask: ${df.format((sumA / (sumB+sumA)) * 100)} " +
                "|" +
                " ${df.format((sumB / (sumB+sumA)) * 100)} :bid ---------------------------")

        for(i in 0 until x.data.bids.size){

            if ((x.data.asks[i][1].toDouble() + x.data.bids[i][1].toDouble()) / (sumB + sumA) * 1000 > 1) {
                println(
                    "ask: ${x.data.asks[i][0]} |  ${x.data.asks[i][1]} | ${df.format(x.data.asks[i][1].toDouble() / sumA * 1000)}" +
                            " ----- " +
                            "${df.format(x.data.bids[i][1].toDouble() / sumB * 1000)} |  ${x.data.bids[i][1]} | ${x.data.bids[i][0]} :bid"
                )
            }
        }

        println("---------------------------------------------------------------")

    }
}