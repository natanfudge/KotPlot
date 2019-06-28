package testPlots


import makeFile
import builders.KotPlot
import constructables.Axis
import constructables.AxisType
import constructables.Point

fun main() {
    val pointsList = List(2) { i ->
        listOf(
            Point(i * 5, i * 5, "Point1"),
            Point(i * 5 + 1, i * 5 - 0.1),
            Point(i * 5 + 2, i * 5 + 2),
            Point(i * 5 + 3, i * 5 + 4),
            Point(i * 5 + 4, i * 5 + 1),
            Point(i * 5 + 4.5, i * 5 + 1)

        )
    }
    val plot = KotPlot.plotGrid {
        plotCell(row = 1) {
            layout(title = "Default (Linear)")
            scatterTrace(points = pointsList[0], name = "Trace1")
            scatterTrace(points = pointsList[1], name = "Trace2")
        }

        plotCell(row = 1) {
            layout(
                title = "Category",
                xAxis = Axis(title = "X values", type = AxisType.Category)
            )
            scatterTrace(points = pointsList[0], name = "Trace1")
            scatterTrace(points = pointsList[1], name = "Trace2")
        }
        plotCell(row = 2) {
            layout(
                title = "Date",
                xAxis = Axis(title = "X values", type = AxisType.Date)
            )
            scatterTrace(points = pointsList[0], name = "Trace1")
            scatterTrace(points = pointsList[1], name = "Trace2")
        }
        plotCell(row = 2) {
            layout(
                title = "Linear",
                xAxis = Axis(title = "X values", type = AxisType.Linear)
            )
            scatterTrace(points = pointsList[0], name = "Trace1")
            scatterTrace(points = pointsList[1], name = "Trace2")
        }
        plotCell(row = 3) {
            layout(
                title = "Log",
                xAxis = Axis(title = "X values", type = AxisType.Log)
            )
            scatterTrace(points = pointsList[0], name = "Trace1")
            scatterTrace(points = pointsList[1], name = "Trace2")
        }

        plotCell(row = 3) {
            layout(
                title = "MultiCategory",
                xAxis = Axis(title = "X values", type = AxisType.MultiCategory)
            )
            scatterTrace(points = pointsList[0], name = "Trace1")
            scatterTrace(points = pointsList[1], name = "Trace2")
        }

    }

    plot.makeFile()
}



