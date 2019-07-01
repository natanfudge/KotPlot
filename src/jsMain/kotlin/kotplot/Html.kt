@file:Suppress("UnusedImport")

package kotplot

import kotlinx.html.*
import kotlinx.html.stream.createHTML
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import kotplot.constructables.PlotConfig
import kotplot.models.Plot
import kotplot.models.internal.Layout
import kotplot.models.internal.Trace
import kotlin.js.JSON
import kotplot.examples.*
import kotplot.models.PlotGrid
import kotlin.browser.document
import kotlinx.serialization.*
import kotplot.builders.KotPlot
import kotplot.constructables.Point

internal fun String.toJsObject() = JSON.parse<dynamic>(this)

/**
 * Returns the javascript plotly function to create this plot as a string.
 */
fun Plot.bindTo(id: String) {
    val json = Json(JsonConfiguration.Stable.copy(prettyPrint = true))
    val traces = json.stringify(Trace.serializer().list, data).toJsObject()
    val layout = json.stringify(Layout.serializer(), layout).toJsObject()
    val config = json.stringify(PlotConfig.serializer(), config).toJsObject()


    Plotly.plot(id, traces, layout, config)

}

external class Plotly {
    companion object {
        fun plot(id: String, data: dynamic, layout: dynamic, config: dynamic)
    }
}


/**
 * Create a full html file string from the plot grid. The ID of the plot is 'plot'.
 */
fun PlotGrid.bindTo(id: String) {

    val node = document.getElementById(id)
    if (node == null) throw InvalidPlotException("There is no dom node with the id '$id'.")

    val rows = this.sortedRows()
    node.innerHTML = createHTML().div(/*"container"*/) {
        rows.forEach {
            plotRow((it))
        }
    }

    rows.forEach { row ->
        row.second.mapIndexed { idx, cell ->
            cell.plot.bindTo("${row.first}-$idx")
        }
    }

}


//TODO think of a more effective way to test plots on js and jvm


//TODO: comment this out when publishing
//fun main() {
//    val list = listOf(Point(0, 0), Point(1, 1), Point(2, 2))
//    KotPlot.plotGrid {
//        plotCell(row = 1) {
//            scatterTrace(list)
//        }
//        plotCell(row = 1) {
//            scatterTrace(list)
//        }
//        plotCell(row = 1) {
//            scatterTrace(list)
//        }
//        plotCell(row = 1) {
//            scatterTrace(list)
//        }
//        plotCell(row = 1) {
//            scatterTrace(list)
//        }
//    }.bindTo("tester")
////    Examples.linesPlots().bindTo("tester")
////    Examples.sizePlots().bindTo("tester2")
////    Examples.rangeAndVisiblePlots().bindTo("tester3")
////    Examples.colorPlots().bindTo("tester4")
////    Examples.columnPlots().bindTo("tester5")
////    Examples.configPlots().bindTo("tester6")
////    Examples.markersPlots().bindTo("tester7")
////    Examples.axisTypePlots().bindTo("tester8")
//
//
//}