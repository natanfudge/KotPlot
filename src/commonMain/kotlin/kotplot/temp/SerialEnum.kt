package kotplot.temp

interface SerialEnum {
    val serialName: String?
}

fun <T> Array<T>.serial() where T : SerialEnum, T : Enum<T> = this.map { it.serialName ?: it.name }.toTypedArray()

