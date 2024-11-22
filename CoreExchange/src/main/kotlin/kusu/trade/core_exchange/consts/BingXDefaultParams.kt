package kusu.trade.core_exchange.consts

object BingXDefaultParams {
    val openInterestParams = mutableMapOf<String, String>(
        //"" to ""
    )
    val markPriceKlineParams = mutableMapOf<String, String>(
        "interval" to "5m",
        "limit" to "1"
    )
    val orderBookParams = mutableMapOf<String, String>(
        "limit" to "500"
    )
}