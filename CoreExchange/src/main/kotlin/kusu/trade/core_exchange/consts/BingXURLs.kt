package kusu.trade.core_exchange.consts

object BingXURLs {

    /**
     * base url
     */
    const val API_URL = "https://open-api.bingx.com"

    const val WS_API_URL = "wss://open-api-swap.bingx.com/swap-market?listenKey=425f783f4a17cd65f4a5d7470cfd45a956dba0c29564aa4b70967bee4e4a8984"

    /**
     * GET
     *
     * USDT-M Perp Futures symbols
     *
     * No API KEY signature required
     */
    const val FUTURE_SYMBOLS = "/openApi/swap/v2/quote/contracts"

    /**
     * GET /openApi/swap/v2/quote/openInterest
     *
     * No API KEY signature required
     */
    const val OPEN_INTEREST = "/openApi/swap/v2/quote/openInterest"

    /**
     * GET /openApi/swap/v2/quote/depth
     *
     * No API KEY signature required
     */
    const val ORDER_BOOK = "/openApi/swap/v2/quote/depth"

    /**
     * GET /openApi/swap/v1/market/markPriceKlines
     *
     * No API KEY signature required
     */
    const val MARK_PRICE_KLINE = "/openApi/swap/v1/market/markPriceKlines"
}