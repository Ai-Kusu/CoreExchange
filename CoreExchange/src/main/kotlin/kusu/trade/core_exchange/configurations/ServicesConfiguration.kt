package kusu.trade.core_exchange.configurations

import kusu.trade.core_exchange.service.subscribe_data.MarketDataSubscribeManager
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ServicesConfiguration {

    @Bean
    fun marketDataSubscribeData(): MarketDataSubscribeManager {
            return MarketDataSubscribeManager()
        }
}