package models.internal

import builders.Symbol
import kotlinx.serialization.*
import temp.*


@Serializable
internal data class Trace(
    val x: List<Double>,
    val y: List<Double>,
    val text: List<String?>,
    val name: String,
    val mode: TraceMode?,
    val type: TraceType = TraceType.Scatter,
    val marker: Marker,
    @SerialName("line")
    val lineType: LineType
)


@Serializable(TraceModeSerializer::class)
internal enum class TraceMode {

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
    LinesAndMarkers,
    @SerialName("none")
    None


}



@Serializable(TraceTypeSerializer::class)
internal enum class TraceType {
    @SerialName("scatter")
    Scatter
}

@Serializable
internal data class Marker (val symbol: Symbol, val size: Int)




