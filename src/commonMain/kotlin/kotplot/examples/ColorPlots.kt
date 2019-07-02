package kotplot.examples


import kotplot.builders.KotPlot
import kotplot.constructables.Axis
import kotplot.constructables.Color
import kotplot.constructables.Point
import kotplot.models.PlotGrid

internal fun GridExamples.colorPlots() : PlotGrid {
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
        plotCell(row = 1) {
            layout(title = "Default  (Black)")
            scatterTrace(points = pointsList[0], name = "Trace1")
            scatterTrace(points = pointsList[1], name = "Trace2")
        }

        plotCell(row = 1) {
            layout(
                title = "Black",
                xAxis = Axis(title = "X values", color = Color.Black)
            )
            scatterTrace(points = pointsList[0], name = "Trace1")
            scatterTrace(points = pointsList[1], name = "Trace2")
        }
        plotCell(row = 2) {
            layout(
                title = "Red",
                xAxis = Axis(title = "X values", color = Color.Red)
            )
            scatterTrace(points = pointsList[0], name = "Trace1")
            scatterTrace(points = pointsList[1], name = "Trace2")
        }
        plotCell(row = 2) {
            layout(
                title = "Green",
                yAxis = Axis(title = "Y values", color = Color.Green)
            )
            scatterTrace(points = pointsList[0], name = "Trace1")
            scatterTrace(points = pointsList[1], name = "Trace2")
        }
        plotCell(row = 3) {
            layout(
                title = "Blue",
                yAxis = Axis(title = "Y values", color = Color.Blue)
            )
            scatterTrace(points = pointsList[0], name = "Trace1")
            scatterTrace(points = pointsList[1], name = "Trace2")
        }
        plotCell(row = 3) {
            layout(
                title = "Orange",
                yAxis = Axis(title = "Y values", color = Color.Orange)
            )
            scatterTrace(points = pointsList[0], name = "Trace1")
            scatterTrace(points = pointsList[1], name = "Trace2")
        }


    }


}



