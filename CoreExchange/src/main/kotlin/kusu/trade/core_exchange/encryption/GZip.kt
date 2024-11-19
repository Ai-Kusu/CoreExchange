package kusu.trade.core_exchange.encryption

import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.util.zip.GZIPInputStream
import java.util.zip.GZIPOutputStream

object GZip {
    fun encodeGzip(data: String): ByteArray {
        val byteArrayOutputStream = ByteArrayOutputStream()
        val gzipOutputStream = GZIPOutputStream(byteArrayOutputStream)

        gzipOutputStream.write(data.toByteArray())
        gzipOutputStream.close()

        return byteArrayOutputStream.toByteArray()
    }

    fun decodeGzip(compressedData: ByteArray): String {
        val gzipInputStream = GZIPInputStream(ByteArrayInputStream(compressedData))
        val buffer = ByteArray(1024)
        val decodedMessage = StringBuilder()

        var len: Int
        while ((gzipInputStream.read(buffer).also { len = it }) != -1) {
            decodedMessage.append(String(buffer, 0, len))
        }

        gzipInputStream.close()
        return decodedMessage.toString()
    }
}
