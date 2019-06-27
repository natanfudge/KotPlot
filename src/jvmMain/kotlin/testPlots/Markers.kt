package testPlots


import builders.kotPlot
import base.makeFile
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import models.*

fun main() {
    val pointsList = List(20) { i ->
        listOf(Point(i * 5, i * 5), Point(i * 5 + 1, i * 5 + 1), Point(i * 5 + 2, i * 5 + 2))
    }


    val plot = kotPlot(showSendToCloud = false) {
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

        scatterTrace(points = pointsList[6], name = "No Markers") {
            markers(show = false)
        }

        scatterTrace(points = pointsList[7], name = "Size = 3") {
            markers(size = 3)
        }


    }

    val json = Json(JsonConfiguration.Stable)
    val str = json.stringify(Plot2D.serializer(), plot)
    println(str)


    plot.makeFile()
}


