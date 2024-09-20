package kusu.trade.core_exchange.datamodels.bibit.exchange_params.ticker

import jakarta.persistence.*
import kotlinx.serialization.Serializable
import kusu.trade.core_exchange.datamodels.bibit.exchange_params.BiBitExchange

@Entity
@Table(name = "tickers")
@Serializable
data class Ticker(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @ManyToOne
    @JoinColumn(name = "exchange_id", nullable = false)
    val exchange: kusu.trade.core_exchange.datamodels.bibit.exchange_params.BiBitExchange,

    val name: String,

    @ManyToOne
    @JoinColumn(name = "ticker_type_id", nullable = false)
    val tickerType: kusu.trade.core_exchange.datamodels.bibit.exchange_params.ticker.TickerType
)