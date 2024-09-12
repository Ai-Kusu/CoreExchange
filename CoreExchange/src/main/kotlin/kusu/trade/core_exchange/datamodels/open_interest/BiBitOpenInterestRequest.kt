package kusu.trade.core_exchange.datamodels.open_interest

import kotlinx.serialization.Serializable

@Serializable
data class BiBitOpenInterestRequest(
    val category: String,   // Product type: linear, inverse
    val symbol: String,     // Symbol name, like BTCUSDT, uppercase only
    val intervalTime: String,   // Interval time: 5min, 15min, 30min, 1h, 4h, 1d
    val startTime: Long? = null,   // The start timestamp (ms)
    val endTime: Long? = null,     // The end timestamp (ms)
    val limit: Int? = 50,          // Limit for data size per page. [1, 200]. Default: 50
    val cursor: String? = null     // Cursor. Used to paginate
)
