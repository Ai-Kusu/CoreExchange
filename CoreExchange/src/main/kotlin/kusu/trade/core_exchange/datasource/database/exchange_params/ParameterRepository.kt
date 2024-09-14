package kusu.trade.core_exchange.datasource.database.exchange_params

import kusu.trade.core_exchange.datamodels.exchange_params.Parameter
import org.springframework.data.jpa.repository.JpaRepository

interface ParameterRepository: JpaRepository<Parameter, Long> {
}