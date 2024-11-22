package kusu.trade.core_exchange.service.console

import kusu.trade.core_exchange.datamodels.bingx.BingXResponseBase
import kusu.trade.core_exchange.datamodels.bingx.kline.BingXMarkPriceKline
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter

object ConsolePresentationKLine : ConsolePresentation<BingXResponseBase<BingXMarkPriceKline>>{


    override fun dataToText(klineData: BingXResponseBase<BingXMarkPriceKline>): String {
        var result = ""

        val data = klineData.data.list[0]

        result += "open: ${data.open}\n" +
                "close: ${data.close}\n" +
                "high: ${data.high}\n" +
                "low: ${data.low}\n" +
                "volume: ${data.volume}\n" +
                "openTime: ${mtt(data.openTime)}\n" +
                "closeTime: ${mtt(data.closeTime)}"

        return result
    }

    private fun mtt(time: Long): String {
        val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        val instant = Instant.ofEpochMilli(time)

        val date = LocalDateTime.ofInstant(instant, ZoneId.systemDefault())
        return formatter.format(date)
    }

}