package kusu.trade.core_exchange.datamodels.bingx.order_book

import kotlinx.serialization.Serializable
import kusu.trade.core_exchange.datamodels.bingx.BingXResponse

@Serializable
data class BingXResponseOrderBook(
    val T: Long,
    val asks: List<List<String>>,
    val bids: List<List<String>>,
    val asksCoin: List<List<String>>,
    val bidsCoin: List<List<String>>
) : BingXResponse()
