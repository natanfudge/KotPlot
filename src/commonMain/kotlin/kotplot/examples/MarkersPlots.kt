package kotplot.examples


import kotplot.builders.KotPlot
import kotplot.builders.Symbol
import kotplot.constructables.Point
import kotplot.models.Plot

internal fun PlotExamples.markersPlots()  : Plot{
    val pointsList = List(20) { i ->
        listOf(
            Point(i * 5, i * 5),
            Point(i * 5 + 1, i * 5 - 0.1),
            Point(i * 5 + 2, i * 5 + 2),
            Point(i * 5 + 3, i * 5 + 4),
            Point(i * 5 + 4, i * 5 + 1)
        )
    }


    return KotPlot.plot  {
        scatterTrace(points = pointsList[0], name = "Circle") {
            markers(symbol = Symbol.Circle, size = 10)
        }
        scatterTrace(points = pointsList[1], name = "Cross") {
            markers(symbol = Symbol.Cross, size = 10)
        }
        scatterTrace(points = pointsList[2], name = "ThinCross") {
            markers(symbol = Symbol.ThinCross, size = 10)
        }
        scatterTrace(points = pointsList[3], name = "SquareCross") {
            markers(symbol = Symbol.SquareCross, size = 10)
        }
        scatterTrace(points = pointsList[4], name = "TriangleDown") {
            markers(symbol = Symbol.TriangleDown, size = 10)
        }
        scatterTrace(points = pointsList[5], name = "TriangleUp") {
            markers(symbol = Symbol.TriangleUp, size = 10)
        }

        scatterTrace(points = pointsList[6], name = "show = false") {
            markers(show = false)
        }

        scatterTrace(points = pointsList[7], name = "Size = 3") {
            markers(size = 3)
        }


    }


}



