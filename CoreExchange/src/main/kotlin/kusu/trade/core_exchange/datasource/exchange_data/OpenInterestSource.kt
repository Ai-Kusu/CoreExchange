package kusu.trade.core_exchange.datasource.exchange_data

import kotlinx.coroutines.flow.flow
import kotlinx.serialization.json.Json
import kusu.trade.core_exchange.consts.BingXURLs
import kusu.trade.core_exchange.datamodels.bingx.BingXResponseBase
import kusu.trade.core_exchange.datamodels.bingx.open_interest.BingXResponseOpenInterest
import kusu.trade.core_exchange.datasource.clients.client.BingXWebClient
import java.util.*

class OpenInterestSource(private val bingXWebClient: BingXWebClient = BingXWebClient.getClient()) :
    ExchangeSource<BingXResponseOpenInterest> {

    override fun subscribe(params: Map<String,String>) = flow{

        while (true){
            val response = bingXWebClient.getRequest(
                BingXURLs.OPEN_INTEREST,
                params
            )

            val jsonR = Json.decodeFromString<BingXResponseBase<BingXResponseOpenInterest>>(response)

            emit(jsonR)

            kotlinx.coroutines.delay(30000)
        }
    }

    override fun getNow(params: Map<String,String>): BingXResponseBase<BingXResponseOpenInterest> {

        val response = bingXWebClient.getRequest(
            BingXURLs.OPEN_INTEREST,
            params
        )

        val jsonR = Json.decodeFromString<BingXResponseBase<BingXResponseOpenInterest>>(response)

        return(jsonR)

    }

}
