package kusu.trade.core_exchange.datamodels

import kotlinx.serialization.Serializable

@Serializable
data class BiBitAuth (
    val reqId: String? = null,
    val op: String,
    val args: List<String>
)