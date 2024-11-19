package kusu.trade.core_exchange

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.runApplication

@SpringBootApplication(exclude = [DataSourceAutoConfiguration::class])
class CoreExchangeApplication

fun main(args: Array<String>) {
	runApplication<CoreExchangeApplication>(*args)
}
