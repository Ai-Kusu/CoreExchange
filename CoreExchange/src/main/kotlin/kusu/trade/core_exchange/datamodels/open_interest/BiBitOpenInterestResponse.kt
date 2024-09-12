package kusu.trade.core_exchange.datamodels.open_interest

import kotlinx.serialization.Serializable

@Serializable
data class BiBitOpenInterestResponse(
    val retCode: Int,
    val retMsg: String,
    val result: Result,
    val retExtInfo: Map<String, String>, // Поскольку структура не определена, используется Map
    val time: Long
)

@Serializable
data class Result(
    val symbol: String,
    val category: String,
    val list: List<OpenInterestItem>,
    val nextPageCursor: String
)

@Serializable
data class OpenInterestItem(
    val openInterest: String,
    val timestamp: String
)