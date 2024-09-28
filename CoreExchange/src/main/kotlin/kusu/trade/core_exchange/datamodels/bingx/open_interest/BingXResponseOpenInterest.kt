package kusu.trade.core_exchange.datamodels.bingx.open_interest

import kotlinx.serialization.Serializable
import kusu.trade.core_exchange.datamodels.bingx.BingXResponse

@Serializable
data class BingXResponseOpenInterest (
    val openInterest: String,
    val symbol: String,
    val time: Long
): BingXResponse()
