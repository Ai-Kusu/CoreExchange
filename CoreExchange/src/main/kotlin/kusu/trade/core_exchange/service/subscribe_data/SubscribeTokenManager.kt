package kusu.trade.core_exchange.service.subscribe_data

interface SubscribeTokenManager {
    suspend fun subscribe(symbol: String, params: MutableMap<String, MutableMap<String, String>>)
    fun stopSubscribe(symbol: String)
    fun continueSubscribe(symbol: String)
    fun getParams(symbol: String): MutableMap<String, MutableMap<String, String>>
    fun setSourceParams(symbol: String, source: String, sourceParams: MutableMap<String, String>)
    fun setParams(symbol: String, allParams: MutableMap<String, MutableMap<String, String>>)
    fun getSubscribes(): MutableMap<String, MarketDataSubscribe>
    fun deleteSubscribe(symbol: String)
}