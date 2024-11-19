package kusu.trade.core_exchange.controllers

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class OpenInterestController {

    @GetMapping("/test")
    fun getOpenInterest(): String {
        return "test"
    }

}
