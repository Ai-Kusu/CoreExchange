package kusu.trade.core_exchange.datamodels

import kotlinx.serialization.Serializable

@Serializable
data class BiBitApiResponse(
    val success: Boolean,
    val ret_msg: String,
    val conn_id: String,
    val req_id: String,
    val op: String
)
