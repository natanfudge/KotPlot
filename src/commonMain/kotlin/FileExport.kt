@file:Suppress("UnusedImport")

import constructables.PlotConfig
import kotlinx.html.*
import kotlinx.html.stream.createHTML
import models.*
import models.internal.Layout
import models.internal.Trace
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import models.internal.PlotCell
import kotlinx.serialization.*

/**
 * Returns the javascript plotly function to create this plot as a string.
 */
fun Plot.toJs(id : String): String {
    val json = Json(JsonConfiguration.Stable.copy(prettyPrint = true))
    val tracesParsed = json.stringify(Trace.serializer().list, data)
    val layoutParsed = if (layout != null) json.stringify(Layout.serializer(), layout) else null
    val configParsed = json.stringify(PlotConfig.serializer(), config)

    return """
                        Plotly.newPlot(
                        '$id',
                        $tracesParsed,
                        $layoutParsed,
                        $configParsed
                        );
                    """.trimIndent()
}

/**
 * Create a full html file string from the plot. The ID of the plot is 'plot'.
 */
fun Plot.toHtml(): String = createHTML().html {
    head {
        meta(charset = "utf-8") {
            script(src = "https://cdn.plot.ly/plotly-latest.min.js") {}
            link(
                rel = "stylesheet",
                href = "https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
            )
        }
        if (layout != null) title(layout.title)
    }
    body {
        div { id = "plot" }
        script {
            unsafe {
                +this@toHtml.toJs(id = "plot")
            }
        }
    }
}




/**
 * Create a full html file string from the plot grid. The ID of the plot is 'plot'.
 */
fun PlotGrid.toHtml(): String {
    val rows = cells.groupBy { it.rowNumber }.mapValues {
        it.value.sortedBy { plot -> plot.column }
    }.toList().sortedBy { it.first }


    return createHTML().html {
        head {
            meta {
                charset = "utf-8"
                script { src = "https://cdn.plot.ly/plotly-latest.min.js" }
                link(
                    rel = "stylesheet",
                    href = "https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
                )
                script { src = "https://code.jquery.com/jquery-3.3.1.slim.min.js" }
                script { src = "https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" }
                script { src = "https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" }
            }
            title(this@toHtml.title)
        }
        body {
            plotGrid(rows)
            rows.forEach { row ->
                row.second.mapIndexed { idx, cell ->
                    script {
                        unsafe {
                            +cell.plot.toJs("${row.first}-$idx")
                        }
                    }
                }
            }
        }
    }
}

private fun FlowContent.plotRow(row: Pair<Int, List<PlotCell>>) = div("row") {
    row.second.mapIndexed { idx, cell ->
        if (cell.size != null) {
            div("col col-${cell.size}") {
                id = "${row.first}-$idx"
            }
        } else {
            div("col") {
                id = "${row.first}-$idx"
            }
        }
    }
}

private fun FlowContent.plotGrid(rows: List<Pair<Int, List<PlotCell>>>) = div("container") {
    rows.forEach {
        plotRow((it))
    }
}
