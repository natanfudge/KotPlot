package kotplot.examples


import kotplot.builders.KotPlot
import kotplot.constructables.Axis
import kotplot.constructables.AxisType
import kotplot.constructables.Point
import kotplot.models.PlotGrid
import kotplot.toHtml
import kotplot.toJs
import kotlin.js.JsName

fun testJS() {
    println("kotlin to js!")
}

fun main() {
    val plot = GridExamples.axisTypePlots()
    println(plot.toHtml())
}

object PlotExamples {

}

object GridExamples {

}

fun GridExamples.axisTypePlots() {
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
    val plot =  KotPlot.plotGrid {
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
                xAxis = Axis(
                    title = "X values",
                    type = AxisType.MultiCategory
                )
            )
            scatterTrace(points = pointsList[0], name = "Trace1")
            scatterTrace(points = pointsList[1], name = "Trace2")
        }

    }


}



