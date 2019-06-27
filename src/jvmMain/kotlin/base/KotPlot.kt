package base

import models.*

object KotPlot {
    fun plot(init: Plot2DBuilder.() -> Unit): Plot2D = Plot2DBuilder().apply(init).build()
}

class Plot2DBuilder {

    //TODO: use @paramof or dataarg when it's a thing
    //TODO: convert into init block
    private val data: MutableList<Trace> = mutableListOf()

    /**
     *@param points The points to be traced
     *@param name The trace name appears as the list of labels that identifies the trace and on hover.
     */
    fun scatterTrace(
        points: Iterable<Point>,
        name: String = "trace ${data.size}",
        init: TraceBuilder.() -> Unit = {}
    ) {
        data.add(
            TraceBuilder(
                points.map { it.x },
                points.map { it.y },
                points.map { it.text },
                name
            ).apply(init).build()
        )
    }

    //TODO: convert into init block
    private var layout: Layout = Layout(title = "", xAxis = Axis(), yAxis = Axis())

    /**
     * @param title Text that will be displayed above the plot
     * @param xAxis customizes the x [Axis]
     * @param yAxis customizes the y [Axis]
     */
    fun layout(title: String = "", xAxis: Axis = Axis(), yAxis: Axis = Axis()) {
        layout = Layout(title, xAxis, yAxis)
    }

    internal fun build() = Plot2D(data, layout)

}

class TraceBuilder(
    private val x: List<Double>,
    private val y: List<Double>,
    private val text: List<String?>,
    private val name: String
) {
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
     */
    fun markers(show: Boolean = true, symbol: Symbol = Symbol.circle, size: Int = 6) {
        showMarkers = show
        marker = Marker(symbol, size)
    }

    /**
     * Configures the appearance of the lines connecting between the points
     */
    fun lines(show: Boolean = true, shape: Shape = Shape.linear) {
        showLines = show
        lineType = LineType(shape)
    }

    internal fun build(): Trace {
        val traceMode = when {
            showMarkers && showLines -> TraceMode.LinesAndMarkers
            showMarkers -> TraceMode.Markers
            showLines -> TraceMode.Lines
            else -> null
        }
        //TODO: check behavior of null tracemode
        return Trace(x, y, text, name, traceMode, marker = marker, lineType = lineType)
    }

}