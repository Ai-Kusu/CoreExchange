package kusu.trade.core_exchange.service

import kusu.trade.core_exchange.datamodels.bingx.BingXResponse
import kusu.trade.core_exchange.datasource.clients.client.BingXWebClient
import kusu.trade.core_exchange.datasource.exchange_data.ExchangeSource
import kusu.trade.core_exchange.datasource.exchange_data.MarkPriceKlineSource
import kusu.trade.core_exchange.datasource.exchange_data.OpenInterestSource
import kusu.trade.core_exchange.datasource.exchange_data.OrderBookSubscribe

class MarketDataSubscribeData(private val bingXWebClient: BingXWebClient): SubscribeTokenData {

   override fun subscribe(symbol: String) {
       val openInterestSource = OpenInterestSource(bingXWebClient)
       val markPriceKlineSource = MarkPriceKlineSource(bingXWebClient)
       val orderBookSubscribe = OrderBookSubscribe(bingXWebClient)

       val openInterestParams = mapOf<String, String>(
           "symbol" to symbol,
           "" to ""
       )
       val markPriceKlineParams = mapOf<String, String>(
           "symbol" to symbol,
           "" to ""
       )
       val orderBookParams = mapOf<String, String>(
           "symbol" to symbol,
           "" to ""
       )



        while (true){



        }
    }

}
