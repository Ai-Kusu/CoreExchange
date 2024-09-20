package kusu.trade.core_exchange.datamodels.bibit.exchange_response.open_interest

import kotlinx.serialization.Serializable

@Serializable
data class OpenInterestItem(
    val openInterest: String,
    val timestamp: String
)