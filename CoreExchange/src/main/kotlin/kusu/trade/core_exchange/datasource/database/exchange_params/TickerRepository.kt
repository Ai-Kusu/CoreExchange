package kusu.trade.core_exchange.datasource.database.exchange_params

import kusu.trade.core_exchange.datamodels.bibit.exchange_params.ticker.Ticker
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TickerRepository: JpaRepository<Ticker, Long> {
}