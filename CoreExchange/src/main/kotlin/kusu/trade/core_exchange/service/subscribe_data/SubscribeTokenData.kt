package kusu.trade.core_exchange.service.subscribe_data

import kusu.trade.core_exchange.datasource.clients.client.BingXWebClient

abstract class SubscribeTokenData(
    private val bingXWebClient: BingXWebClient,
    private val params: Map<String, Map<String, String>>
) {
    abstract suspend fun subscribe()
    abstract fun stopSubscribe()
    abstract fun continueSubscribe()
    abstract fun getParams(): MutableMap<String, MutableMap<String, String>>
    abstract fun setSourceParams(source: String, sourceParams: MutableMap<String, String>)
    abstract fun setParams(allParams: MutableMap<String, MutableMap<String, String>>)
}