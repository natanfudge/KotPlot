package models

import kotlinx.serialization.Serializable
import temp.JsName


@Serializable
data class Trace internal constructor(
    val x: List<Double>,
    val y: List<Double>,
    val name: String?,
    val mode: TraceMode,
    val type: TraceType,
    val marker: Marker
//    , val line: Line
)

enum class TraceMode {
    lines,
    @JsName("linesMarkers")
    `lines+markers`,
    markers
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