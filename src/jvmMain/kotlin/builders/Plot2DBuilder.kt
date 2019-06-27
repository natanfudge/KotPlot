package builders

import models.*

class Plot2DBuilder(private val responsive: Boolean, private val showSendToCloud: Boolean) : Builder<Plot2D>() {

    //TODO: use @paramof or dataarg when it's a thing

    private val data: MutableList<Trace> = mutableListOf()
    private lateinit var layout: Layout

    init {
        layout()
    }

    /**
     *@param points The points to be traced
     *@param name The trace name appears as the list of labels that identifies the trace and on hover.
     *@param config Call [markers][TraceBuilder.markers] and/or [lines][TraceBuilder.lines] to further customize the trace.
     */
    fun scatterTrace(
        points: Iterable<Point>,
        name: String = "trace ${data.size}",
        config: TraceBuilder.() -> Unit = {}
    ) {
        data.add(
            TraceBuilder(
                points.map { it.x },
                points.map { it.y },
                points.map { it.text },
                name
            ).apply(config).build()
        )
    }


    /**
     * @param title Text that will be displayed above the plot
     * @param xAxis customizes the x [Axis]
     * @param yAxis customizes the y [Axis]
     */
    fun layout(title: String = "", xAxis: Axis = Axis(), yAxis: Axis = Axis()) {
        layout = Layout(title, xAxis, yAxis)
    }

    override fun build() = Plot2D(data, layout, PlotConfig(responsive, showSendToCloud))

}