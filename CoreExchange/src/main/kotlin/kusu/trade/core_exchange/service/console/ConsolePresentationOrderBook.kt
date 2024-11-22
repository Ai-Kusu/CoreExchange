package kusu.trade.core_exchange.service.console

import kusu.trade.core_exchange.datamodels.bingx.BingXResponseBase
import kusu.trade.core_exchange.datamodels.bingx.order_book.BingXResponseOrderBook
import java.text.DecimalFormat

object ConsolePresentationOrderBook : ConsolePresentation<BingXResponseBase<BingXResponseOrderBook>> {

    override fun dataToText(orderBookData: BingXResponseBase<BingXResponseOrderBook>): String {
        var result = ""

        val d = orderBookData.data

        val df = DecimalFormat("#.##")

        val sumA: Double = d.asks.fold(0.0) { sum, element -> sum + element[1].toDouble() }
        val sumB: Double = d.bids.fold(0.0) { sum, element -> sum + element[1].toDouble() }

        for (i in 0 until orderBookData.data.bids.size) {

            if ((orderBookData.data.asks[i][1].toDouble()) / (sumB + sumA) * 1000 > 5) {
                result +=
                    "ask: ${orderBookData.data.asks[i][0]} |  ${orderBookData.data.asks[i][1]} | ${df.format(orderBookData.data.asks[i][1].toDouble() / sumA * 1000)}\n"

            }
        }

        result +=
            "--------------------------- ask: ${df.format((sumA / (sumB + sumA)) * 100)} " +
                    "|" +
                    " ${df.format((sumB / (sumB + sumA)) * 100)} :bid ---------------------------\n"


        for (i in 0 until orderBookData.data.bids.size) {

            if ((orderBookData.data.bids[i][1].toDouble()) / (sumB + sumA) * 1000 > 5) {
                result +=
                    "bid: ${orderBookData.data.bids[i][0]} |  ${orderBookData.data.bids[i][1]} | ${df.format(orderBookData.data.bids[i][1].toDouble() / sumB * 1000)}\n"

            }
        }

        return result
    }
}