package kusu.trade.core_exchange.datasource.database.exchange_params

import kusu.trade.core_exchange.datamodels.bibit.exchange_params.parameter.Parameter
import org.springframework.data.jpa.repository.JpaRepository

interface ParameterRepository: JpaRepository<kusu.trade.core_exchange.datamodels.bibit.exchange_params.parameter.Parameter, Long> {
}