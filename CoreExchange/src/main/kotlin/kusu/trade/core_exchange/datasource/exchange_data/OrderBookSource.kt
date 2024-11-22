package kusu.trade.core_exchange.datasource.exchange_data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.serialization.json.Json
import kusu.trade.core_exchange.consts.BingXURLs
import kusu.trade.core_exchange.datamodels.bingx.BingXResponseBase
import kusu.trade.core_exchange.datamodels.bingx.order_book.BingXResponseOrderBook
import kusu.trade.core_exchange.datasource.clients.client.BingXWebClient
import java.util.*


class OrderBookSubscribe(private val bingXWebClient: BingXWebClient = BingXWebClient.getClient()) :
    ExchangeSource<BingXResponseOrderBook> {

    override fun subscribe(params: Map<String,String>): Flow<BingXResponseBase<BingXResponseOrderBook>> = flow{

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

    override fun getNow(params: Map<String,String>): BingXResponseBase<BingXResponseOrderBook> {

        val response = bingXWebClient.getRequest(
            BingXURLs.ORDER_BOOK,
            params
        )

        val jsonR = Json.decodeFromString<BingXResponseBase<BingXResponseOrderBook>>(response)

        return(jsonR)

    }
}
