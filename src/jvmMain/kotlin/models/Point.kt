package models

data class Point(val x: Double, val y: Double, val text: String? = null) {
    fun toPair() = Pair(x, y)

    constructor(x: Int, y: Int, text: String? = null) : this(x.toDouble(), y.toDouble(), text)
    constructor(x: Double, y: Int, text: String? = null) : this(x, y.toDouble(), text)
    constructor(x: Int, y: Double, text: String? = null) : this(x.toDouble(), y, text)
}
