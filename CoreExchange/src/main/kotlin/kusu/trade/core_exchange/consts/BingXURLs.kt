package kusu.trade.core_exchange.consts

object BingXURLs {
    const val API_URL = "https://open-api.bingx.com"

    /**
     * GET
     *
     * USDT-M Perp Futures symbols
     *
     * No API KEY signature required
     */
    const val FUTURE_SYMBOLS= "/openApi/swap/v2/quote/contracts"
}