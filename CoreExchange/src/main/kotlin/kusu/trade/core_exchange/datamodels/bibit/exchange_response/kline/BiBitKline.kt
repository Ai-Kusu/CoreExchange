package kusu.trade.core_exchange.datamodels.bibit.exchange_response.kline

import kotlinx.serialization.Serializable

@Serializable
data class BiBitKline(
    val topic: String,
    val type: String,
    val ts: Long,
    val data: List<kusu.trade.core_exchange.datamodels.bibit.exchange_response.kline.ByBitKlineData>
)

