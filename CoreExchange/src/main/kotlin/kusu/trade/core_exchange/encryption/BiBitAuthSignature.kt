package kusu.trade.core_exchange.encryption

import org.apache.commons.codec.binary.Hex
import javax.crypto.Mac
import javax.crypto.spec.SecretKeySpec

class BiBitAuthSignature {
    fun genSignature(secret: String, expires: Long): String {
        val _val = "GET/realtime$expires"

        val hmacSha256: ByteArray
        try {
            val secretKeySpec = SecretKeySpec(secret.toByteArray(), "HmacSHA256")
            val mac = Mac.getInstance("HmacSHA256")
            mac.init(secretKeySpec)
            hmacSha256 = mac.doFinal(_val.toByteArray())
            return Hex.encodeHexString(hmacSha256)

        } catch (e: Exception) {
            throw RuntimeException("Failed to calculate hmac-sha256", e)
        }
    }
}