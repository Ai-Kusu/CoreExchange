package kusu.trade.core_exchange.datasource.exchange_data

import kotlinx.coroutines.flow.flow
import kotlinx.serialization.json.Json
import kusu.trade.core_exchange.consts.BingXURLs
import kusu.trade.core_exchange.datamodels.bingx.BingXResponseBase
import kusu.trade.core_exchange.datamodels.bingx.open_interest.BingXResponseOpenInterest
import kusu.trade.core_exchange.datasource.clients.client.BingXWebClient
import java.util.*

class OpenInterestSubscribe(private val bingXWebClient: BingXWebClient = BingXWebClient.getClient()) {

    fun subscribe(symbol: String) = flow{
        val params = TreeMap<String,String>()
        params["symbol"] = symbol

        while (true){
            val response = bingXWebClient.getRequest(
                BingXURLs.OPEN_INTEREST,
                params
            )

            val jsonR = Json.decodeFromString<BingXResponseBase<BingXResponseOpenInterest>>(response)

            emit(jsonR)

            kotlinx.coroutines.delay(1000)
        }
    }

    suspend fun get(symbol: String): BingXResponseBase<BingXResponseOpenInterest> {
        val params = TreeMap<String,String>()
        params["symbol"] = symbol

        val response = bingXWebClient.getRequest(
            BingXURLs.OPEN_INTEREST,
            params
        )

        val jsonR = Json.decodeFromString<BingXResponseBase<BingXResponseOpenInterest>>(response)

        return(jsonR)

    }
}
