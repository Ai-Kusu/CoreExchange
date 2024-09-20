package kusu.trade.core_exchange.datamodels.bibit.exchange_response.open_interest

import kotlinx.serialization.Serializable
import kusu.trade.core_exchange.datamodels.bibit.exchange_response.BiBitResponse

@Serializable
data class BiBitOpenInterestResponse(
    val retCode: Int,
    val retMsg: String,
    val result: kusu.trade.core_exchange.datamodels.bibit.exchange_response.open_interest.Result,
    val retExtInfo: Map<String, String>, // Поскольку структура не определена, используется Map
    val time: Long
) : kusu.trade.core_exchange.datamodels.bibit.exchange_response.BiBitResponse()
