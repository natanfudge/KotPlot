package doc

import base.makeFile
import builders.KotPlot
import models.Point

fun main() {
    val points = listOf(Point(0, 0), Point(1, 1), Point(2, 2))

    val plot = KotPlot.plot {
        scatterTrace(points)
    }

    plot.makeFile()
}