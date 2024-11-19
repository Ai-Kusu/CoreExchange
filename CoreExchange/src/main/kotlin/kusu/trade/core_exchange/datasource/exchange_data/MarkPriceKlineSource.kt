package kusu.trade.core_exchange.datasource.exchange_data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.serialization.json.Json
import kusu.trade.core_exchange.consts.BingXURLs
import kusu.trade.core_exchange.datamodels.bingx.BingXResponseBase
import kusu.trade.core_exchange.datamodels.bingx.kline.BingXMarkPriceKline
import kusu.trade.core_exchange.datasource.clients.client.BingXWebClient
import java.util.*

class MarkPriceKlineSource(private val bingXWebClient: BingXWebClient = BingXWebClient.getClient())
    : ExchangeSource<BingXMarkPriceKline> {

    override fun subscribe(params: TreeMap<String, String>): Flow<BingXResponseBase<BingXMarkPriceKline>> = flow{

        while (true){
            val response = bingXWebClient.getRequest(
                BingXURLs.MARK_PRICE_KLINE,
                params
            )

            println(response)

            val jsonR = Json.decodeFromString<BingXResponseBase<BingXMarkPriceKline>>(response)

            emit(jsonR)

            kotlinx.coroutines.delay(30000)
        }
    }

    override fun getNow(params: TreeMap<String, String>): BingXResponseBase<BingXMarkPriceKline> {

        val response = bingXWebClient.getRequest(
            BingXURLs.MARK_PRICE_KLINE,
            params
        )

        val jsonR = Json.decodeFromString<BingXResponseBase<BingXMarkPriceKline>>(response)

        return(jsonR)

    }
}
