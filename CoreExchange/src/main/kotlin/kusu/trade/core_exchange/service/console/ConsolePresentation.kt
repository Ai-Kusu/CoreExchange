package kusu.trade.core_exchange.service.console

import kusu.trade.core_exchange.datamodels.bingx.BingXResponse
import kusu.trade.core_exchange.datamodels.bingx.BingXResponseBase

interface ConsolePresentation <T> {
    fun dataToText(data: T): String
}