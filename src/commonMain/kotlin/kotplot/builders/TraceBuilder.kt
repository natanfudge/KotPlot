package kotplot.builders

import kotlinx.serialization.Serializable
import kotplot.models.internal.LineType
import kotplot.models.internal.Marker
import kotplot.models.internal.Trace
import kotplot.models.internal.TraceMode
import kotplot.temp.SerialEnum
import kotplot.temp.ShapeSerializer
import kotplot.temp.SymbolSerializer

class TraceBuilder(
    private val x: List<Double>,
    private val y: List<Double>,
    private val text: List<String?>,
    private val name: String
) : Builder() {
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
enum class Symbol(override val serialName: String?) : SerialEnum {
    Circle("circle"),
    TriangleUp("triangle-up"),
    TriangleDown("triangle-down"),
    SquareCross("square-cross"),
    ThinCross("cross-thin"),
    Cross("cross")
}

@Serializable(ShapeSerializer::class)
enum class Shape(override val serialName: String?) : SerialEnum {
    /**
     * The line will go horizontally towards the next point and then vertically towards it in a straight line.
     */
    HorizontalThenVertical("hv"),
    /**
     * The line will go vertically towards the next point and then horizontally towards it in a straight line.
     */
    VerticalThenHorizontal("vh"),
    /**
     * The line will go half way horizontally towards the next point, and then vertically all the way towards it,
     * and then it will go the other half horizontally towards it in a straight line.
     */
    HorizontalThenVerticalThenHorizontal("hvh"),
    /**
     * The line will go half way vertically towards the next point, and then horizontally all the way towards it,
     * and then it will go the other half vertically towards it in a straight line.
     */
    VerticalThenHorizontalThenVertical("vhv"),
    /**
     * The line will go towards the next point in a curved way.
     */
    Spline("spline"),
    /**
     * The line will be a straight line between two points.
     */
    Linear("linear")
}