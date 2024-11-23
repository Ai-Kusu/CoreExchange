package kusu.trade.core_exchange.controllers

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kusu.trade.core_exchange.service.subscribe_data.MarketDataSubscribe
import kusu.trade.core_exchange.service.subscribe_data.MarketDataSubscribeManager
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController("/subscribe")
class SubscribeDataController @Autowired constructor(private val sourceManager: MarketDataSubscribeManager) {


    @PostMapping("/create/{symbol}")
    fun createSubscribe(@PathVariable symbol: String) {
        val params = mutableMapOf<String, MutableMap<String, String>>()
        try {

            //TODO переделать это недорозумение
            GlobalScope.launch {

                sourceManager.subscribe(symbol, params)
            }

        } catch (e: Exception){

        }
    }

    @PostMapping("/stop/{symbol}")
    fun stopSubscribe(@PathVariable symbol: String) {
        try {
            sourceManager.stopSubscribe(symbol)
        } catch (e: Exception){

        }
    }

    @PostMapping("/continue/{symbol}")
    fun continueSource(@PathVariable symbol: String) {
        try {
            sourceManager.continueSubscribe(symbol)
        } catch (e: Exception){

        }
    }

    @PostMapping("/delete/{symbol}")
    fun deleteSubscribe(@PathVariable symbol: String) {
        try {
            sourceManager.deleteSubscribe(symbol)
        } catch (e: Exception){

        }
    }

    @PostMapping("/get/")
    fun getSubscribesList(): MutableMap<String, MarketDataSubscribe> {
        return sourceManager.getSubscribes()
    }

    @PostMapping("/get/{symbol}")
    fun getSubscribe(@PathVariable symbol: String): MutableMap<String, MutableMap<String, String>> {
        return sourceManager.getParams(symbol)
    }


}
