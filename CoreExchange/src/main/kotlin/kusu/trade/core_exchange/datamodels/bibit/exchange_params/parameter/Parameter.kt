package kusu.trade.core_exchange.datamodels.bibit.exchange_params.parameter

import jakarta.persistence.*
import kotlinx.serialization.Serializable
import kusu.trade.core_exchange.datamodels.bibit.exchange_params.BiBitExchange

@Entity
@Table(name = "parameters")
@Serializable
data class Parameter(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @ManyToOne
    @JoinColumn(name = "exchange_id", nullable = false)
    val exchange: kusu.trade.core_exchange.datamodels.bibit.exchange_params.BiBitExchange,

    val name: String,

    @ManyToOne
    @JoinColumn(name = "parameter_type_id", nullable = false)
    val parameterType: kusu.trade.core_exchange.datamodels.bibit.exchange_params.parameter.ParameterType
)
