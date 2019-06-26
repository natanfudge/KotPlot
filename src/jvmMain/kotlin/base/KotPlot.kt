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
     *@param name The trace name appears as the list of labels that identifies the trace and on hover.
     *@param marker Determines the appearance of each point in the plot
     */
    fun trace(
        points: Iterable<Point>,
        name: String? = null,
        type: TraceType = TraceType.scatter,
        mode: TraceMode = TraceMode.lines,
        marker: Marker = Marker()
    ) {
        data.add(Trace(points.map { it.x }, points.map { it.y }, name, mode, type, marker))
    }

    fun layout(title: String = "Untitled models", xAxis: Axis, yAxis: Axis) {
        layout = Layout(title, xAxis, yAxis)
    }

    internal fun build() = Plot2D(data, layout)

}