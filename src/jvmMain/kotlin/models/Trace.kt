package models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import temp.JsName


@Serializable
data class Trace internal constructor(
    val x: List<Double>,
    val y: List<Double>,
    val text : List<String?>,
    val name: String,
    val mode: TraceMode,
    val type: TraceType,
    val marker: Marker,
    @SerialName("line")
    val lineType: LineType
)

class TraceMode private  constructor(val mode : String) {
    operator fun plus(other : TraceMode) = TraceMode("${this.mode}+${other.mode}")

    companion object{
        val Lines = TraceMode("lines")
        val Markers = TraceMode("markers")
    }

////    @JsName("linesMarkers")
////    `lines+markers`,
//    markers("markers")
}

enum class TraceType {
    scatter
}

@Serializable
data class Marker(val symbol : Symbol = Symbol.circle, val size : Int = 6)

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