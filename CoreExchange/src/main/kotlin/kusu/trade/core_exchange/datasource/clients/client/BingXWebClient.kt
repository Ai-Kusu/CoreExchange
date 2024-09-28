package kusu.trade.core_exchange.datasource.clients.client

import kusu.trade.core_exchange.consts.BingXURLs
import kusu.trade.core_exchange.encryption.BingXAuthSignature.generateHmac256
import kusu.trade.core_exchange.encryption.BingXAuthSignature.getMessageToDigest
import kusu.trade.core_exchange.encryption.BingXAuthSignature.getRequestUrl
import org.springframework.http.HttpStatusCode
import org.springframework.web.reactive.function.client.WebClient
import java.sql.Timestamp
import java.util.*

class BingXWebClient {

    private val bingXClient: WebClient = WebClient
        .builder()
        .baseUrl(BingXURLs.API_URL)
        .build()

    fun getRequest(path : String, parameters: TreeMap<String, String>): String{

        val method = "GET"
        val timestamp = "" + Timestamp(System.currentTimeMillis()).getTime()


        val valueToDigest: String = getMessageToDigest(parameters)
        val messageDigest: String = generateHmac256(valueToDigest)
        val parametersString = "$valueToDigest&signature=$messageDigest"
        val requestUrl: String = getRequestUrl(path, parametersString)


        val response = bingXClient.get().uri(requestUrl)
            .exchangeToMono { response ->
                if (response.statusCode() == HttpStatusCode.valueOf(200)){
                    response.bodyToMono(String::class.java).doOnNext { x ->

                    }
                } else{
                    throw Exception("BAD REQUEST ${response.statusCode()}")
                }
            }.block()

        return response!!
    }



    companion object{
        private val bingXWebClient = BingXWebClient()

        fun getClient(): BingXWebClient {

            return bingXWebClient
        }
    }
}