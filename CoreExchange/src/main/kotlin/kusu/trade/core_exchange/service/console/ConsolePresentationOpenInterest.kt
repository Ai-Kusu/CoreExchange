package kusu.trade.core_exchange.service.console

import kusu.trade.core_exchange.datamodels.bingx.BingXResponseBase
import kusu.trade.core_exchange.datamodels.bingx.open_interest.BingXResponseOpenInterest

object ConsolePresentationOpenInterest  : ConsolePresentation<BingXResponseBase<BingXResponseOpenInterest>>{
    override fun dataToText(x: BingXResponseBase<BingXResponseOpenInterest>): String {
        var result = ""

        val d = x.data

        result += "Open interest: ${d.openInterest}"

        return result
    }
}