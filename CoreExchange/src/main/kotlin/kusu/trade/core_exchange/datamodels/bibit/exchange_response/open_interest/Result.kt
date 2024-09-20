package kusu.trade.core_exchange.datamodels.bibit.exchange_response.open_interest

import kotlinx.serialization.Serializable

@Serializable
data class Result(
    val symbol: String,
    val category: String,
    val list: List<kusu.trade.core_exchange.datamodels.bibit.exchange_response.open_interest.OpenInterestItem>,
    val nextPageCursor: String
)