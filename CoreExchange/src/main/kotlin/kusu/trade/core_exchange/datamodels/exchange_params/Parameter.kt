package kusu.trade.core_exchange.datamodels.exchange_params

import jakarta.persistence.*

@Entity
@Table(name = "parameters")
data class Parameter(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @ManyToOne
    @JoinColumn(name = "exchange_id", nullable = false)
    val exchange: Exchange,

    val name: String,

    @ManyToOne
    @JoinColumn(name = "parameter_type_id", nullable = false)
    val parameterType: ParameterType
)
