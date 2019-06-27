package base

import models.*

object KotPlot {
    fun plot(init: Plot2DBuilder.() -> Unit): Plot2D = Plot2DBuilder().apply(init).build()
}

class Plot2DBuilder {
    private val data: MutableList<Trace> = mutableListOf()
    //TODO: figure out the default for this
    private lateinit var layout: Layout

    //TODO: use @paramof or dataarg when it's a thing
    /**
     *@param points The points to be traced
     *@param name The trace name appears as the list of labels that identifies the trace and on hover.
     *@param mode Determines the drawing mode for this scatter trace.
     * If the provided `mode` includes "text" then the `text` field of the points appear at the coordinates.
     * Otherwise, the `text` elements appear on hover.
     * @param marker Determines the appearance of each point in the plot.
     */
    fun scatterTrace(
        points: Iterable<Point>,
        name: String = "trace ${data.size}",
        mode: TraceMode = TraceMode.lines,
        marker: Marker = Marker(),
        lineType: LineType = LineType()
    ) {
        data.add(Trace(points.map { it.x }, points.map { it.y },points.map { it.text },  name, mode, TraceType.scatter, marker, lineType))
    }

    /**
     * @param title Text that will be displayed above the plot
     * @param xAxis customizes the x [Axis]
     * @param yAxis customizes the y [Axis]
     */
    fun layout(title: String = "Untitled models", xAxis: Axis, yAxis: Axis) {
        layout = Layout(title, xAxis, yAxis)
    }

    internal fun build() = Plot2D(data, layout)

}