package kusu.trade.core_exchange.datasource.exchange_data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.serialization.json.Json
import kusu.trade.core_exchange.consts.BingXURLs
import kusu.trade.core_exchange.datamodels.bingx.BingXResponse
import kusu.trade.core_exchange.datamodels.bingx.BingXResponseBase
import kusu.trade.core_exchange.datamodels.bingx.open_interest.BingXResponseOpenInterest
import kusu.trade.core_exchange.datamodels.bingx.order_book.BingXResponseOrderBook
import kusu.trade.core_exchange.datasource.clients.client.BingXWebClient
import java.text.DecimalFormat
import java.util.*


class OrderBookSubscribe(private val bingXWebClient: BingXWebClient = BingXWebClient.getClient()) :
    ExchangeSource<BingXResponseOrderBook> {

    override fun subscribe(params: TreeMap<String,String>): Flow<BingXResponseBase<BingXResponseOrderBook>> = flow{

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

    override fun getNow(params: TreeMap<String,String>): BingXResponseBase<BingXResponseOrderBook> {

        val response = bingXWebClient.getRequest(
            BingXURLs.ORDER_BOOK,
            params
        )

        val jsonR = Json.decodeFromString<BingXResponseBase<BingXResponseOrderBook>>(response)

        return(jsonR)

    }
}

/*
suspend fun main() {
    OrderBookSubscribe().subscribe("SUI-USDT", "500").collect{ x ->
        val d = x.data

        val df = DecimalFormat("#.##")

        val sumA: Double = d.asks.fold(0.0) { sum, element -> sum + element[1].toDouble() }
        val sumB: Double = d.bids.fold(0.0) { sum, element -> sum + element[1].toDouble() }



        for(i in 0 until x.data.bids.size){

            if ((x.data.asks[i][1].toDouble()) / (sumB + sumA) * 1000 > 5) {
                println(
                    "ask: ${x.data.asks[i][0]} |  ${x.data.asks[i][1]} | ${df.format(x.data.asks[i][1].toDouble() / sumA * 1000)}"
                )
            }
        }

        println("--------------------------- ask: ${df.format((sumA / (sumB+sumA)) * 100)} " +
                "|" +
                " ${df.format((sumB / (sumB+sumA)) * 100)} :bid ---------------------------")

        for(i in 0 until x.data.bids.size){

            if ((x.data.bids[i][1].toDouble()) / (sumB + sumA) * 1000 > 5) {
                println(
                            "bid: ${x.data.bids[i][0]} |  ${x.data.bids[i][1]} | ${df.format(x.data.bids[i][1].toDouble() / sumB * 1000)}"
                )
            }
        }

        println("---------------------------------------------------------------")

    }
}*/