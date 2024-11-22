package kusu.trade.core_exchange.datamodels.bingx

import kotlinx.serialization.Serializable
import kusu.trade.core_exchange.datamodels.bingx.kline.BingXMarkPriceKline
import kusu.trade.core_exchange.datamodels.bingx.kline.BingXMarkPriceKlineElement

@Serializable
data class BingXResponseBase <T> (
    val code: Int,
    val msg: String,
    val data: T
) where T : BingXResponse

@Serializable
data class BingXResponseBaseList <T> (
    val code: Int,
    val msg: String,
    val data: List<T>
) where T : BingXResponse
