package kusu.trade.core_exchange.service

import kotlinx.coroutines.runBlocking
import kusu.trade.core_exchange.consts.BingXDefaultParams
import kusu.trade.core_exchange.service.subscribe_data.MarketDataSubscribeData
import kusu.trade.core_exchange.service.subscribe_data.SubscribeTokenData


class SourceManager {

    private val sourceMap = mutableMapOf<String, SubscribeTokenData>()

    fun createSource(symbol: String, param: MutableMap<String, MutableMap<String, String>>){
        if (sourceMap[symbol] != null) throw Exception()

        val params = mutableMapOf(
            "openInterestParams" to
                    if (param["openInterestParams"] == null)
                        BingXDefaultParams.openInterestParams else param["openInterestParams"]!!,

            "markPriceKlineParams" to
                    if (param["markPriceKlineParams"] == null)
                        BingXDefaultParams.markPriceKlineParams else param["markPriceKlineParams"]!!,

            "orderBookParams" to
                    if (param["orderBookParams"] == null)
                        BingXDefaultParams.orderBookParams else param["orderBookParams"]!!,
        )

        params["openInterestParams"]!!["symbol"] = symbol
        params["markPriceKlineParams"]!!["symbol"] = symbol
        params["orderBookParams"]!!["symbol"] = symbol

        sourceMap[symbol] = MarketDataSubscribeData(params)

        runBlocking {
            sourceMap[symbol]?.subscribe()
        }
    }

    fun stopSource(symbol: String){
        if (sourceMap[symbol] == null) throw Exception()

        sourceMap[symbol]?.stopSubscribe()
    }

    fun continueSource(symbol: String){
        if (sourceMap[symbol] == null) throw Exception()

        sourceMap[symbol]?.continueSubscribe()
    }

    fun deleteSource(symbol: String){
        if (sourceMap[symbol] == null) throw Exception()

        stopSource(symbol)
        sourceMap.remove(symbol)
    }

    fun getSourceList(): MutableMap<String, MutableMap<String, MutableMap<String, String>>> {
        val sourceList: MutableMap<String, MutableMap<String, MutableMap<String, String>>> = mutableMapOf()

        for (i in sourceMap.keys){
            sourceList[i] = sourceMap[i]!!.getParams()
        }

        return sourceList
    }

    fun getSource(symbol: String): MutableMap<String, MutableMap<String, String>> {
        if (sourceMap[symbol] == null) throw Exception()

        return sourceMap[symbol]!!.getParams()
    }

    companion object{

        private var sourceManager: SourceManager? = null

        fun getInstance(): SourceManager {
            if (sourceManager == null) sourceManager = SourceManager()

            return sourceManager!!
        }

    }
}
