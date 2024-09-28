package kusu.trade.core_exchange.datamodels.bingx.kline

import kotlinx.serialization.Serializable
import kusu.trade.core_exchange.datamodels.bingx.BingXResponse

@Serializable
data class BingXResponseKlineList(
    val list: List<BingXMarkPriceKline>
) : BingXResponse()

