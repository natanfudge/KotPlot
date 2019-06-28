package builders

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import models.internal.*
import models.internal.LineType
import models.internal.Marker
import models.internal.Trace
import models.internal.TraceMode
import temp.ShapeDeserializer
import temp.SymbolSerializer

class TraceBuilder(
    private val x: List<Double>,
    private val y: List<Double>,
    private val text: List<String?>,
    private val name: String
)  : Builder(){
    private lateinit var marker: Marker
    private lateinit var lineType: LineType
    private var showMarkers: Boolean = true
    private var showLines: Boolean = true

    init {
        markers()
        lines()
    }

    /**
     * Configures the appearance of each point in the plot.
     * @param show Set to false to disable markers
     * @param symbol How each marker looks like
     */
    fun markers(show: Boolean = true, symbol: Symbol = Symbol.Circle, size: Int = 6) {
        showMarkers = show
        marker = Marker(symbol, size)
    }

    /**
     * Configures the appearance of the lines connecting between the points
     * @param show Set to false to disable points
     * @param shape Determines the way two points connect with each other
     */
    fun lines(show: Boolean = true, shape: Shape = Shape.Linear) {
        showLines = show
        lineType = LineType(shape)
    }

    internal fun build(): Trace {
        val traceMode = when {
            showMarkers && showLines -> TraceMode.LinesAndMarkers
            showMarkers -> TraceMode.Markers
            showLines -> TraceMode.Lines
            else -> TraceMode.None
        }
        return Trace(x, y, text, name, traceMode, marker = marker, lineType = lineType)
    }

}

@Serializable(SymbolSerializer::class)
enum class Symbol {
    @SerialName("circle")
    Circle,
    @SerialName("triangle-up")
    TriangleUp,
    @SerialName("triangle-down")
    TriangleDown,
    @SerialName("square-cross")
    SquareCross,
    @SerialName("cross-thin")
    ThinCross,
    @SerialName("cross")
    Cross
}

@Serializable(ShapeDeserializer::class)
enum class Shape {
    /**
     * The line will go horizontally towards the next point and then vertically towards it in a straight line.
     */
    @SerialName("hv")
    HorizontalThenVertical,
    @SerialName("vh")
    /**
     * The line will go vertically towards the next point and then horizontally towards it in a straight line.
     */
    VerticalThenHorizontal,
    @SerialName("hvh")
    /**
     * The line will go half way horizontally towards the next point, and then vertically all the way towards it,
     * and then it will go the other half horizontally towards it in a straight line.
     */
    HorizontalThenVerticalThenHorizontal,
    @SerialName("vhv")
    /**
     * The line will go half way vertically towards the next point, and then horizontally all the way towards it,
     * and then it will go the other half vertically towards it in a straight line.
     */
    VerticalThenHorizontalThenVertical,
    @SerialName("spline")
    /**
     * The line will go towards the next point in a curved way.
     */
    Spline,
    /**
     * The line will be a straight line between two points.
     */
    Linear
}