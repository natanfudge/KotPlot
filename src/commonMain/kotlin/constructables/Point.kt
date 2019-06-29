package constructables

/**
 * A two-dimensional point with [x] and [y] coordinates
 * @param text If the provided `mode` includes "text" then the `text` field of the points appear at the coordinates.
 * Otherwise, the `text` elements appear on hover
 *
 */
data class Point(val x: Double, val y: Double, val text: String? = null) {
    fun toPair() = Pair(x, y)

    constructor(x: Int, y: Int, text: String? = null) : this(x.toDouble(), y.toDouble(), text)
    constructor(x: Double, y: Int, text: String? = null) : this(x, y.toDouble(), text)
    constructor(x: Int, y: Double, text: String? = null) : this(x.toDouble(), y, text)
}
