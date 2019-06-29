package doc

import builders.KotPlot
import constructables.Point
import jvmExtensions.show


//TODO: convert to multiplatform
fun main() {
    val points = listOf(Point(0, 0), Point(1, 1), Point(2, 2))

    val plot = KotPlot.plot {
        scatterTrace(points)
    }

    plot.show()
}