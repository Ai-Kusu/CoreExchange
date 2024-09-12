package kusu.trade.core_exchange.datamodels.order_book

import kotlinx.serialization.Serializable

@Serializable
class BiBitOrderBookData (
    val s: String,
    val b: List<List<String>>, // Список бидов (buy orders)
    val a: List<List<String>>, // Список асков (sell orders)
    val u: Long,
    val seq: Long
)