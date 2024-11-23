package kusu.trade.core_exchange.service.subscribe_data


class MarketDataSubscribeManager(
): SubscribeTokenManager {

    private val subscribes: MutableMap<String, MarketDataSubscribe> = mutableMapOf()


    override suspend fun subscribe(symbol: String, params: MutableMap<String, MutableMap<String, String>>) {
        if (subscribes[symbol] == null) subscribes[symbol] = MarketDataSubscribe(params)
        subscribes[symbol]!!.subscribe()
    }

    override fun stopSubscribe(symbol: String) {
        if (subscribes[symbol] == null) throw Exception()
        subscribes[symbol]!!.stopSubscribe()
    }

    override fun deleteSubscribe(symbol: String) {
        if (subscribes[symbol] == null) throw Exception()
        subscribes.remove(symbol)
    }

    override fun continueSubscribe(symbol: String) {
        if (subscribes[symbol] == null) throw Exception()
        subscribes[symbol]!!.continueSubscribe()
    }

    override fun getSubscribes(): MutableMap<String, MarketDataSubscribe> {
        return subscribes
    }

    override fun getParams(symbol: String): MutableMap<String, MutableMap<String, String>> {
        if (subscribes[symbol] == null) throw Exception()
        return subscribes[symbol]!!.getParams()
    }

    override fun setSourceParams(symbol: String, source: String, sourceParams: MutableMap<String, String>) {
        if (subscribes[symbol] == null) throw Exception()
        subscribes[symbol]!!.setSourceParams(source, sourceParams)
    }

    override fun setParams(symbol: String, allParams: MutableMap<String, MutableMap<String, String>>) {
        if (subscribes[symbol] == null) throw Exception()
        subscribes[symbol]!!.setParams(allParams)
    }


}

