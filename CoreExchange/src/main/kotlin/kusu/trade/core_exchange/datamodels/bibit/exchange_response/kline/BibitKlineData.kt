package kusu.trade.core_exchange.datamodels.bibit.exchange_response.kline

import kotlinx.serialization.Serializable
import kusu.trade.core_exchange.datamodels.bibit.exchange_response.BiBitResponse

@Serializable
data class ByBitKlineData(
    val start: Long,
    val end: Long,
    val interval: String,
    val open: String,
    val close: String,
    val high: String,
    val low: String,
    val volume: String,
    val turnover: String,
    val confirm: Boolean,
    val timestamp: Long
) : kusu.trade.core_exchange.datamodels.bibit.exchange_response.BiBitResponse()
