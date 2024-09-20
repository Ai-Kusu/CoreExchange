package kusu.trade.core_exchange.datamodels.bibit.exchange_params.parameter

import jakarta.persistence.*
import kotlinx.serialization.Serializable

@Entity
@Table(name = "parameter_types")
@Serializable
data class ParameterType(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val name: String
)

