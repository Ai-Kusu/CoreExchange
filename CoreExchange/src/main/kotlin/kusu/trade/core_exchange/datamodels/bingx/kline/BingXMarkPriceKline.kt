package kusu.trade.core_exchange.datamodels.bingx.kline

import kotlinx.serialization.Serializable

@Serializable
data class BingXMarkPriceKline(
    val open: Double,
    val close: Double,
    val high: Double,
    val low: Double,
    val volume: Double,
    val time: Long
)
