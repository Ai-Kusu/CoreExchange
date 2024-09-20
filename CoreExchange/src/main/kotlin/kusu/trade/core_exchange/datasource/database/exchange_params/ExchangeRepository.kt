package kusu.trade.core_exchange.datasource.database.exchange_params

import kusu.trade.core_exchange.datamodels.bibit.exchange_params.BiBitExchange
import org.springframework.data.jpa.repository.JpaRepository

interface ExchangeRepository: JpaRepository<kusu.trade.core_exchange.datamodels.bibit.exchange_params.BiBitExchange, Long> {
}