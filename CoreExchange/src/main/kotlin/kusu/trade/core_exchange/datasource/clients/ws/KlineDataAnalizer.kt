package kusu.trade.core_exchange.datasource.clients.ws

import kusu.trade.core_exchange.datamodels.kline.BiBitKline
import kusu.trade.core_exchange.datamodels.order_book.BiBitOrderBook

fun printData(x: BiBitKline): Unit {
    for (i in x.data){
        println("time: ${x.ts} open price: ${i.open} close price: ${i.close}")
    }
}

fun printData2(x: BiBitOrderBook): Unit {

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