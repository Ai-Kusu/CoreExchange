package kusu.trade.core_exchange.datamodels.bingx.contract

import kotlinx.serialization.Serializable
import kusu.trade.core_exchange.datamodels.bingx.BingXRequest

//@Entity
//@Table(name = "request_data")
@Serializable
data class BingXRequestContractData(
    //@Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
   // val id: Long? = null,

    //@Column(nullable = false)
    val symbol: String,

    //@Column(name = "recv_window", nullable = false)
    val recvWindow: Long, // изменено на Long, так как int64 соответствует 64-битному целому типу

    //@Column(nullable = false)
    val timestamp: Long
) : BingXRequest()