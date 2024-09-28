package kusu.trade.core_exchange.datamodels.bingx

import kotlinx.serialization.Serializable

@Serializable
data class BingXResponseBase <T> (

    val code: Int,
    val msg: String,
    val data: T

) where T : BingXResponse