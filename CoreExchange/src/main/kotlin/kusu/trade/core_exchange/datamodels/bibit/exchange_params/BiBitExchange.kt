package kusu.trade.core_exchange.datamodels.bibit.exchange_params

import jakarta.persistence.*
import kotlinx.serialization.Serializable

@Entity
@Table(name = "exchanges")
@Serializable
data class BiBitExchange (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long, // Используем Long для автоинкремента
    val name: String,

    override var test: List<String> = listOf("id", "name")


) : kusu.trade.core_exchange.datamodels.bibit.exchange_params.BiBitExchangeParam()
