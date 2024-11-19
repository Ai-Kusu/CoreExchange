package kusu.trade.core_exchange.datamodels.bingx.kline

import kotlinx.serialization.Serializable
import kusu.trade.core_exchange.datamodels.bingx.BingXResponse

@Serializable
data class BingXMarkPriceKlineElement(
    val open: Double,
    val close: Double,
    val high: Double,
    val low: Double,
    val volume: Double,
    val openTime: Long,
    val closeTime: Long

) : BingXResponse()