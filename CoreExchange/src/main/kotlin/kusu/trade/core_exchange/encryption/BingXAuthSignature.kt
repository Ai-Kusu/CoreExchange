package kusu.trade.core_exchange.encryption

import kotlinx.serialization.json.Json
import kusu.trade.core_exchange.consts.BingXURLs
import kusu.trade.core_exchange.datamodels.bingx.BingXResponseBase
import kusu.trade.core_exchange.datamodels.bingx.contract.BingXResponseContractData
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import java.net.URLConnection
import java.security.InvalidKeyException
import java.security.NoSuchAlgorithmException
import java.sql.Timestamp
import java.util.*
import javax.crypto.Mac
import javax.crypto.spec.SecretKeySpec



object BingXAuthSignature {

    var apiKey: String = ""
    var secretKey: String = ""

    private val HEX_ARRAY: CharArray = "0123456789ABCDEF".toCharArray()

    /**
     * byte array to hex string
     */
    fun bytesToHex(bytes: ByteArray): String {
        val hexChars = CharArray(bytes.size * 2)
        for (j in bytes.indices) {
            val v = bytes[j].toInt() and 0xFF
            hexChars[j * 2] = HEX_ARRAY[v ushr 4]
            hexChars[j * 2 + 1] = HEX_ARRAY[v and 0x0F]
        }
        return String(hexChars)
    }

    /**
     * generate Hash-based Message Authentication Code
     */
    @Throws(NoSuchAlgorithmException::class, InvalidKeyException::class)
    private fun hmac(algorithm: String?, key: ByteArray?, message: ByteArray?): ByteArray {
        val mac: Mac = Mac.getInstance(algorithm)
        mac.init(SecretKeySpec(key, algorithm))
        return mac.doFinal(message)
    }

    /**
     * generate hmac for message by HmacSHA256 with secretKey
     */
    fun generateHmac256(message: String): String {
        try {
            val bytes = hmac("HmacSHA256", secretKey.toByteArray(), message.toByteArray())
            return bytesToHex(bytes)
        } catch (e: Exception) {
            println("generateHmac256 expection:$e")
        }
        return ""
    }


    /**
     * Digest string для запросов
     */
    fun getMessageToDigest(parameters: TreeMap<String, String>): String {
        var first = true
        var valueToDigest = ""
        for ((key, value) in parameters) {
            if (!first) {
                valueToDigest += "&"
            }
            first = false
            valueToDigest += "$key=$value"
        }
        return valueToDigest
    }

    /**
     * Конструктор ссылки
     */
    fun getRequestUrl(path: String, parameters: String): String {
        val urlStr: String = "$path?$parameters"
        return urlStr
    }

    fun execute(requestUrl: String?, method: String?): String {
        try {
            val url: URL = URL(requestUrl)
            val conn: URLConnection = url.openConnection()
            val http: HttpURLConnection = conn as HttpURLConnection
            http.setRequestMethod(method) // PUT is another valid option
            http.setDoOutput(true)
            conn.setDoOutput(true)
            conn.setDoInput(true)

            var result = ""
            var line = ""
            val `in` = BufferedReader(
                InputStreamReader(conn.getInputStream())
            )
            while ((`in`.readLine().also { line = it }) != null) {
                result += line
            }

             return result
        } catch (e: Exception) {
            println("expection:$e")
            throw Exception()
        }
    }
}