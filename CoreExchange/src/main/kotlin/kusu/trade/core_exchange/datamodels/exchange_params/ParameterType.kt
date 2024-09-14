package kusu.trade.core_exchange.datamodels.exchange_params

import jakarta.persistence.*

@Entity
@Table(name = "parameter_types")
data class ParameterType(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val name: String
)

