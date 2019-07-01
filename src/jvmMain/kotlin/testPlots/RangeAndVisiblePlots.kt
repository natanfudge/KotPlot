package testPlots


import kotplot.toHtml
import kotplot.builders.KotPlot
import kotplot.constructables.Axis
import kotplot.constructables.Color
import kotplot.constructables.Point
import kotplot.jvmExtensions.show
import kotlinx.serialization.Serializable

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

        plotCell(row = 1) {
            layout(
                title = "Default (range = null)",
                xAxis = Axis(title = "X values", color = Color.Black)
            )
            scatterTrace(points = pointsList[0], name = "Trace1")
            scatterTrace(points = pointsList[1], name = "Trace2")
        }

        plotCell(row = 1) {
            layout(
                title = "range = 0.0..6.0",
                xAxis = Axis(
                    title = "X values",
                    color = Color.Black,
                    range = 0.0..6.0
                )
            )
            scatterTrace(points = pointsList[0], name = "Trace1")
            scatterTrace(points = pointsList[1], name = "Trace2")
        }

        plotCell(row = 2) {
            layout(
                title = "range = -3.0..3.0",
                xAxis = Axis(
                    title = "X values",
                    color = Color.Black,
                    range = -3.0..3.0
                )
            )
            scatterTrace(points = pointsList[0], name = "Trace1")
            scatterTrace(points = pointsList[1], name = "Trace2")
        }
        plotCell(row = 2) {
            layout(
                title = "range = 3.0..9.0",
                xAxis = Axis(
                    title = "X values",
                    color = Color.Black,
                    range = 3.0..9.0
                )
            )
            scatterTrace(points = pointsList[0], name = "Trace1")
            scatterTrace(points = pointsList[1], name = "Trace2")
        }
        plotCell(row = 3) {
            layout(
                title = "Invisible X",
                xAxis = Axis(title = "X values", visible = false)
            )
            scatterTrace(points = pointsList[0], name = "Trace1")
            scatterTrace(points = pointsList[1], name = "Trace2")
        }

        plotCell(row = 3) {
            layout(
                title = "Invisible Y",
                yAxis = Axis(title = "Y values", visible = false)
            )
            scatterTrace(points = pointsList[0], name = "Trace1")
            scatterTrace(points = pointsList[1], name = "Trace2")
        }

    }

    print(plot.toHtml())

    plot.show()
//
//    val w = Wrapper(Pair(0.2,0.3))
//    print(stringify(Wrapper.serializer(),w))
}

@Serializable
class Wrapper(val pair: Pair<Double, Double>)
