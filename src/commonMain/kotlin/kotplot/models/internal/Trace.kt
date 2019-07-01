package kotplot.models.internal

import kotplot.builders.Symbol
import kotlinx.serialization.*
import kotplot.temp.SerialEnum
import kotplot.temp.TraceModeSerializer
import kotplot.temp.TraceTypeSerializer


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
internal enum class TraceMode(override val serialName: String?)  : SerialEnum {

    /**
     * Lines will connect between the points.
     */
    Lines("lines"),
    /**
     * Markers will appear at the points' location.
     */
    Markers("markers"),
    LinesAndMarkers("markers+lines"),
    None("none")


}


@Serializable(TraceTypeSerializer::class)
internal enum class TraceType(override val serialName: String?)  : SerialEnum {
    Scatter("scatter")
}

@Serializable
internal data class Marker(val symbol: Symbol, val size: Int)


