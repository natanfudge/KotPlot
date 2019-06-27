package builders

import models.*

class TraceBuilder(
    private val x: List<Double>,
    private val y: List<Double>,
    private val text: List<String?>,
    private val name: String
)  : Builder<Trace>(){
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

    override fun build(): Trace {
        val traceMode = when {
            showMarkers && showLines -> TraceMode.LinesAndMarkers
            showMarkers -> TraceMode.Markers
            showLines -> TraceMode.Lines
            else -> TraceMode.None
        }
        return Trace(x, y, text, name, traceMode, marker = marker, lineType = lineType)
    }

}