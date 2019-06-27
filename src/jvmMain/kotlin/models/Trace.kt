package models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import temp.InlineSerializer
import temp.JsName


@Serializable
data class Trace internal constructor(
    val x: List<Double>,
    val y: List<Double>,
    val text: List<String?>,
    val name: String,
    val mode: TraceMode?,
    val type: TraceType = TraceType.scatter,
    val marker: Marker,
    @SerialName("line")
    val lineType: LineType
)

enum class TraceMode {

    /**
     * Lines will connect between the points.
     */
    @SerialName("lines")
    Lines,

    /**
     * Markers will appear at the points' location.
     */
    @SerialName("markers")
    Markers,
    @SerialName("markers+lines")
    LinesAndMarkers


}

enum class TraceType {
    scatter
}

@Serializable
data class Marker(val symbol: Symbol, val size: Int)

enum class Symbol {
    circle,
    @JsName("triangleUp")
    `triangle-up`,
    @JsName("triangleDown")
    `triangle-down`,
    @JsName("squareCross")
    `square-cross`,
    @JsName("crossThin")
    `cross-thin`,
    cross
}