package kusu.trade.core_exchange.datamodels.bibit.exchange_params

import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@Serializable
abstract class BiBitExchangeParam(){

    @Transient
    abstract var test: List<String>

}
