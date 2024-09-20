package kusu.trade.core_exchange.datasource.clients.ws

import kusu.trade.core_exchange.datamodels.bibit.exchange_response.kline.BiBitKline
import kusu.trade.core_exchange.datamodels.bibit.exchange_response.order_book.BiBitOrderBook

fun printData(x: kusu.trade.core_exchange.datamodels.bibit.exchange_response.kline.BiBitKline): Unit {
    for (i in x.data){
        println("time: ${x.ts} open price: ${i.open} close price: ${i.close}")
    }
}

fun printData2(x: kusu.trade.core_exchange.datamodels.bibit.exchange_response.order_book.BiBitOrderBook): Unit {

    var aSize: Double = 0.0
    var bSize: Double = 0.0
    for (i in x.data.a){
        aSize += i[0].toDouble() * i[1].toDouble()
    }

    for (i in x.data.b){
        bSize += i[0].toDouble() * i[1].toDouble()
    }

    println("aSize: $aSize bSize: $bSize")
}