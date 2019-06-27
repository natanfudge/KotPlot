package doc

import base.KotPlot
import base.makeFile
import models.Point

fun main() {
    val points = listOf(Point(0, 0), Point(1, 1), Point(2, 2))

    val plot = KotPlot.plot {
        scatterTrace(points)
    }

    plot.makeFile()
}