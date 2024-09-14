package kusu.trade.core_exchange.datamodels.exchange_params

import jakarta.persistence.*

@Entity
@Table(name = "exchanges")
data class Exchange(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long, // Используем Long для автоинкремента
    val name: String
)
