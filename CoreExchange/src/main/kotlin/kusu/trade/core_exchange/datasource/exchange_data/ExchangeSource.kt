package kusu.trade.core_exchange.datasource.exchange_data

import kotlinx.coroutines.flow.Flow
import kusu.trade.core_exchange.datamodels.bingx.BingXResponse
import kusu.trade.core_exchange.datamodels.bingx.BingXResponseBase
import kusu.trade.core_exchange.datamodels.bingx.open_interest.BingXResponseOpenInterest
import java.util.*

interface ExchangeSource<T: BingXResponse> {
    fun subscribe(params: Map<String, String>): Flow<BingXResponseBase<T>>
    fun getNow(params: Map<String,String>): BingXResponseBase<T>
}
