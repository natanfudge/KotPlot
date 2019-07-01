package kotplot.examples


import kotplot.builders.KotPlot
import kotplot.constructables.Point
import kotplot.models.PlotGrid



fun Examples.sizePlots(): PlotGrid {
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
    return KotPlot.plotGrid(title = "Colors") {

        repeat(5) { row ->
            repeat(row + 1) { column ->
                plotCell(row = row + 1) {
                    layout(
                        title = "Default (size = 0), ${column + 1} of ${row + 1}"
                    )
                    scatterTrace(points = pointsList[0], name = "Trace1")
                    scatterTrace(points = pointsList[1], name = "Trace2")
                }
            }
        }

        repeat(5) { row ->
            repeat(row + 1) { column ->
                plotCell(row = row + 1 + 5, size = 3) {
                    layout(
                        title = "size = 3, ${column + 1} of ${row + 1}"
                    )
                    scatterTrace(points = pointsList[0], name = "Trace1")
                    scatterTrace(points = pointsList[1], name = "Trace2")
                }
            }
        }

        repeat(5) { row ->
            repeat(row + 1) { column ->
                plotCell(row = row + 1 + 10, size = 6) {
                    layout(
                        title = "size = 6, ${column + 1} of ${row + 1}"
                    )
                    scatterTrace(points = pointsList[0], name = "Trace1")
                    scatterTrace(points = pointsList[1], name = "Trace2")
                }
            }
        }

    }


}

