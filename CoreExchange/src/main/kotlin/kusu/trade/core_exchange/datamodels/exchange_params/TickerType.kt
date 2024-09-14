package kusu.trade.core_exchange.datamodels.exchange_params

import jakarta.persistence.*

@Entity
@Table(name = "ticker_type")
data class TickerType(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val name: String
)

