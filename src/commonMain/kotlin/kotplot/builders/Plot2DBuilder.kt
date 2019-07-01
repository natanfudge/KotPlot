package kotplot.builders

import kotplot.constructables.Axis
import kotplot.constructables.PlotConfig
import kotplot.constructables.Point
import kotplot.models.Plot
import kotplot.models.internal.Layout
import kotplot.models.internal.Trace

class Plot2DBuilder(private val config: PlotConfig) : Builder() {

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

    internal fun build() = Plot(data, layout, config)

}