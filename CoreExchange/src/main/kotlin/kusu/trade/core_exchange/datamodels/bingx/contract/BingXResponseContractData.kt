package kusu.trade.core_exchange.datamodels.bingx.contract

import kotlinx.serialization.Serializable
import kusu.trade.core_exchange.datamodels.bingx.BingXResponse


//@Entity
//@Table(name = "contract_data")
@Serializable
data class BingXResponseContractData(
    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    //val id: Long? = null,

    //@Column(name = "contract_id", nullable = false)
    val contractId: String,

    //@Column(nullable = false)
    val symbol: String,

    //@Column(name = "quantity_precision", nullable = false)
    val quantityPrecision: Int,

    //@Column(name = "price_precision", nullable = false)
    val pricePrecision: Int,

    //@Column(name = "taker_fee_rate", nullable = false)
    val takerFeeRate: Double, // float64 соответствует Double в Kotlin

    //@Column(name = "maker_fee_rate", nullable = false)
    val makerFeeRate: Double, // float64 соответствует Double в Kotlin

    //@Column(name = "trade_min_quantity", nullable = false)
    val tradeMinQuantity: Double, // float64 соответствует Double в Kotlin

    //@Column(name = "trade_min_usdt", nullable = false)
    val tradeMinUSDT: Double, // float64 соответствует Double в Kotlin

    //@Column(nullable = false)
    val currency: String,

    //@Column(nullable = false)
    val asset: String,

    //@Column(nullable = false)
    val status: Int,

    //@Column(name = "api_state_open", nullable = false)
    val apiStateOpen: String,

    //@Column(name = "api_state_close", nullable = false)
    val apiStateClose: String,

    //@Column(name = "ensure_trigger", nullable = false)
    val ensureTrigger: Boolean, // bool соответствует Boolean в Kotlin

    //@Column(name = "trigger_fee_rate", nullable = false)
    val triggerFeeRate: String,

    //@Column(name = "broker_state", nullable = false)
    val brokerState: Boolean // bool соответствует Boolean в Kotlin
) : BingXResponse()