package kusu.trade.core_exchange.datamodels.order_book

import kotlinx.serialization.Serializable

@Serializable
class BiBitOrderBook (
    val topic: String,
    val type: String,
    val ts: Long,
    val data: BiBitOrderBookData,
    val cts: Long
)