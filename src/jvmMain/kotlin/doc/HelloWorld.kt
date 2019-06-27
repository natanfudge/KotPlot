package doc

import builders.kotPlot
import base.makeFile
import models.Point

fun main() {
    val points = listOf(Point(0, 0), Point(1, 1), Point(2, 2))

    val plot = kotPlot {
        scatterTrace(points)
    }

    plot.makeFile()
}