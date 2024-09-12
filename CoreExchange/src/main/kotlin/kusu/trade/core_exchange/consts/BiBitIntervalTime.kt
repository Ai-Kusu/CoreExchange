package kusu.trade.core_exchange.consts

enum class BiBitIntervalTime(val str: String) {
    MINUTE5("5m"),
    MINUTE15("15m"),
    MINUTE30("30m"),
    HOUR1("1h"),
    HOUR4("4h"),
    DAY("1d");

    companion object {
        private const val INTERVAL_TIME = "intervalTime"

        fun getUrlParameter(x: BiBitIntervalTime): String {
            return INTERVAL_TIME + "=${x.str}"
        }
    }
}
