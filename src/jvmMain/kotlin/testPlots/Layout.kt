package testPlots


import base.makeFile
import base.toHtml
import builders.KotPlot
import models.*

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
        plotCell(rowNumber = 1) {
            layout(title = "Default")
            scatterTrace(points = pointsList[0], name = "Test")
            scatterTrace(points = pointsList[1], name = "Test2")
        }

        plotCell(rowNumber = 1) {
            layout(
                title = "AxisType.Category",
                xAxis = Axis(title = "X values", type = AxisType.Category)
            )
            scatterTrace(points = pointsList[0], name = "Test")
            scatterTrace(points = pointsList[1], name = "Test2")
        }
        plotCell(rowNumber = 2) {
            layout(
                title = "AxisType.Date",
                xAxis = Axis(title = "X values", type = AxisType.Date)
            )
            scatterTrace(points = pointsList[0], name = "Test")
            scatterTrace(points = pointsList[1], name = "Test2")
        }
        plotCell(rowNumber = 2) {
            layout(
                title = "AxisType.Linear",
                xAxis = Axis(title = "X values", type = AxisType.Linear)
            )
            scatterTrace(points = pointsList[0], name = "Test")
            scatterTrace(points = pointsList[1], name = "Test2")
        }
        plotCell(rowNumber = 3) {
            layout(
                title = "AxisType.Log",
                xAxis = Axis(title = "X values", type = AxisType.Log)
            )
            scatterTrace(points = pointsList[0], name = "Test")
            scatterTrace(points = pointsList[1], name = "Test2")
        }

        plotCell(rowNumber = 3) {
            layout(
                title = "AxisType.MultiCategory",
                xAxis = Axis(title = "X values", type = AxisType.MultiCategory)
            )
            scatterTrace(points = pointsList[0], name = "Test")
            scatterTrace(points = pointsList[1], name = "Test2")
        }

    }

//    val plot = KotPlot.plotGrid {
    KotPlot.plot {
        layout(
            title = "Plot 1",
            xAxis = Axis(title = "X values"),
            yAxis = Axis(title = "Y values")
        )
        scatterTrace(points = pointsList[0], name = "Test")
        scatterTrace(points = pointsList[1], name = "Test2")
    }
//    }

    val html  = plot.toHtml()
//    print(html)
//    val plot1 = KotPlot.
//    val plot2 = kotPlot {
//        layout(
//            title = "Plot 2",
//            xAxis = Axis(title = "X values"),
//            yAxis = Axis(title = "Y values")
//        )
//        scatterTrace(points = pointsList[0], name = "Test")
//        scatterTrace(points = pointsList[1], name = "Test2")
//    }
//    val plot3 = kotPlot {
//        layout(
//            title = "Plot 3",
//            xAxis = Axis(title = "X values"),
//            yAxis = Axis(title = "Y values")
//        )
//        scatterTrace(points = pointsList[0], name = "Test")
//        scatterTrace(points = pointsList[1], name = "Test2")
//    }
//    val plot4 = kotPlot {
//        layout(
//            title = "Plot 4",
//            xAxis = Axis(title = "X values"),
//            yAxis = Axis(title = "Y values")
//        )
//        scatterTrace(points = pointsList[0], name = "Test")
//        scatterTrace(points = pointsList[1], name = "Test2")
//    }

//    val json = Json(JsonConfiguration.Stable)
//    val str = json.stringify(Plot2D.serializer(), plot)
//    println(str)

    plot.makeFile()
//    plot2.makeFile()
//    plot3.makeFile()
//    plot4.makeFile()
}



