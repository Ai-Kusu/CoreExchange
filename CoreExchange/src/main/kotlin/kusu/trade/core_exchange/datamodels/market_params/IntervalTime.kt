package kusu.trade.core_exchange.datamodels.market_params

import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "interval_time")
data class IntervalTime(
    val time: String,
    val exchange: Int
)
