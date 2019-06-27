package base

import kotlinx.html.*
import kotlinx.html.stream.createHTML
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import kotlinx.serialization.list
import models.*
import java.awt.Desktop
import java.io.File


/**
 * Create a html string for page
 */
/**
 * Create a html string from plot
 */
fun Plot2D.toHtml(): String {
    val json = Json(JsonConfiguration.Stable)
    val tracesParsed = json.stringify(Trace.serializer().list, data)
    val layoutParsed = if (layout != null) json.stringify(Layout.serializer(), layout) else null
    val configParsed = json.stringify(PlotConfig.serializer(), config)

    return createHTML().html {
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
                    +"""
                        Plotly.newPlot(
                        'plot',
                        $tracesParsed,
                        $layoutParsed,
                        $configParsed
                        );
                    """.trimIndent()
                }
            }
        }
    }
}

/**
 * Create a standalone html with the page
 * @param file the reference to html file. If null, create a temporary file
 * @param show if true, start the browser after file is created
 */
fun Plot2D.makeFile(file: File? = null, show: Boolean = true) {
    val actualFile = file ?: File.createTempFile("tempPlot", ".html")
    actualFile.writeText(this.toHtml())
    if (show) {
        Desktop.getDesktop().browse(actualFile.toURI())
    }
}