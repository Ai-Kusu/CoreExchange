package kusu.trade.core_exchange.datamodels.bibit.exchange_response.order_book

import kotlinx.serialization.Serializable

@Serializable
class BiBitOrderBook (
    val topic: String,
    val type: String,
    val ts: Long,
    val data: kusu.trade.core_exchange.datamodels.bibit.exchange_response.order_book.BiBitOrderBookData,
    val cts: Long
)