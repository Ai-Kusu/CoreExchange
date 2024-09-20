package kusu.trade.core_exchange.datamodels.bibit.exchange_params.ticker

import jakarta.persistence.*
import kotlinx.serialization.Serializable
import kusu.trade.core_exchange.datamodels.bibit.exchange_params.BiBitExchangeParam

@Entity
@Table(name = "ticker_type")
@Serializable
data class TickerType(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val name: String,

     override var test: List<String>
) : kusu.trade.core_exchange.datamodels.bibit.exchange_params.BiBitExchangeParam()
