package testPlots


import kotplot.builders.KotPlot
import kotplot.constructables.Point
import kotplot.jvmExtensions.show

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
    val plot = KotPlot.plotGrid(title = "Colors") {

        plotCell {
            layout(
                title = "Default (column = Int.MAX_VALUE)"
            )
            scatterTrace(points = pointsList[0], name = "Trace1")
            scatterTrace(points = pointsList[1], name = "Trace2")
        }

        plotCell(column = 2) {
            layout(
                title = "column = 2"
            )
            scatterTrace(points = pointsList[0], name = "Trace1")
            scatterTrace(points = pointsList[1], name = "Trace2")
        }

        plotCell(column = 1) {
            layout(
                title = "column = 1"
            )
            scatterTrace(points = pointsList[0], name = "Trace1")
            scatterTrace(points = pointsList[1], name = "Trace2")
        }


    }


    plot.show()
}

