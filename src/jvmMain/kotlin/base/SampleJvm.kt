package base

import builders.KotPlot
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import models.*




fun main() {
    val pointsList = List(20) { i ->
        listOf(
            Point(i * 5, i * 5),
            Point(i * 5 + 1, i * 5 - 0.1),
            Point(i * 5 + 2, i * 5 + 2),
            Point(i * 5 + 3, i * 5 + 4),
            Point(i * 5 + 4, i * 5 + 1)
        )
    }


    val plot = KotPlot.plot (PlotConfig(showSendToCloud = false)) {
        scatterTrace(points = pointsList[0], name = "HorizontalThenVertical") {
            lines(shape = Shape.HorizontalThenVertical)
        }
        scatterTrace(points = pointsList[1], name = "VerticalThenHorizontal") {
            lines(shape = Shape.VerticalThenHorizontal)
        }
        scatterTrace(points = pointsList[2], name = "HorizontalThenVerticalThenHorizontal") {
            lines(shape = Shape.HorizontalThenVerticalThenHorizontal)
        }
        scatterTrace(points = pointsList[3], name = "VerticalThenHorizontalThenVertical") {
            lines(shape = Shape.VerticalThenHorizontalThenVertical)
        }
        scatterTrace(points = pointsList[4], name = "Linear") {
            lines(shape = Shape.Linear)
        }
        scatterTrace(points = pointsList[5], name = "Spline") {
            lines(shape = Shape.Spline)
        }
    }

    val json = Json(JsonConfiguration.Stable)
    val str = json.stringify(Plot2D.serializer(), plot)
    println(str)


    plot.makeFile()

}

