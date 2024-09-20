package kusu.trade.core_exchange.datamodels.bibit.exchange_response.order_book

import kotlinx.serialization.Serializable
import kusu.trade.core_exchange.datamodels.bibit.exchange_response.BiBitResponse

@Serializable
class BiBitOrderBookData (
    val s: String,
    val b: List<List<String>>, // Список бидов (buy orders)
    val a: List<List<String>>, // Список асков (sell orders)
    val u: Long,
    val seq: Long
) : kusu.trade.core_exchange.datamodels.bibit.exchange_response.BiBitResponse()