package kusu.trade.core_exchange.controllers

import kusu.trade.core_exchange.service.SourceManager
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController("/subscribe")
class SubscribeDataController {

    private val sourceManager = SourceManager.getInstance()

    @PostMapping("/create/{symbol}")
    fun createSource(@PathVariable symbol: String) {
        val params = mutableMapOf<String, MutableMap<String, String>>()
        try {
            sourceManager.createSource(symbol, params)
        } catch (e: Exception){

        }
    }

    @PostMapping("/stop/{symbol}")
    fun stopSource(@PathVariable symbol: String) {
        try {
            sourceManager.stopSource(symbol)
        } catch (e: Exception){

        }
    }

    @PostMapping("/continue/{symbol}")
    fun continueSource(@PathVariable symbol: String) {
        try {
            sourceManager.continueSource(symbol)
        } catch (e: Exception){

        }
    }

    @PostMapping("/delete/{symbol}")
    fun deleteSource(@PathVariable symbol: String) {
        try {
            sourceManager.deleteSource(symbol)
        } catch (e: Exception){

        }
    }

    @PostMapping("/get/")
    fun getSourceList(): Map<String, MutableMap<String, String>>{
        return sourceManager.getSourceList()
    }

    @PostMapping("/get/{symbol}")
    fun getSource(@PathVariable symbol: String): MutableMap<String, String>{
        return sourceManager.getSource(symbol)
    }


}
