package kusu.trade.core_exchange.datasource.database.exchange_params

import kusu.trade.core_exchange.datamodels.bibit.exchange_params.ticker.TickerType
import org.springframework.data.jpa.repository.JpaRepository

interface TickerTypeRepository: JpaRepository<kusu.trade.core_exchange.datamodels.bibit.exchange_params.ticker.TickerType, Long> {
}