package doc

import builders.KotPlot
import constructables.Point
import jvmExtensions.show
import toHtml


fun main() {
    val points = listOf(Point(0, 0), Point(1, 1), Point(2, 2))

    val plot = KotPlot.plot {
        scatterTrace(points)
    }

    print(plot.toHtml())

    plot.show()
}