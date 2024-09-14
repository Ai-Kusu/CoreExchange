package kusu.trade.core_exchange.datasource.database.exchange_params

import kusu.trade.core_exchange.datamodels.exchange_params.TickerType
import org.springframework.data.jpa.repository.JpaRepository

interface TickerTypeRepository: JpaRepository<TickerType, Long> {
}