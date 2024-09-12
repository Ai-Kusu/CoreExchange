package kusu.trade.core_exchange.datamodels.kline

import kotlinx.serialization.Serializable

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
)
