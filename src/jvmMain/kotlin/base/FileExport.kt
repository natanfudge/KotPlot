package base
import kotlinx.html.*
import kotlinx.html.stream.createHTML
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import kotlinx.serialization.list
import models.*


/**
 * Create a html string for page
 */
/**
 * Create a html string from plot
 */
fun Plot2D.toHtml(): String {
    val json = Json(JsonConfiguration.Stable)
    val tracesParsed = json.stringify(Trace.serializer().list,data)
    val layoutParsed = if(layout != null) json.stringify(Layout.serializer(),layout) else null

    return createHTML().html {
        head {
            meta(charset = "utf-8") {
                script(src = "https://cdn.plot.ly/plotly-latest.min.js"){}
                link(
                    rel = "stylesheet",
                    href = "https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
                )
            }
            if(layout!=null) title(layout.title)
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
                        
                        {showSendToCloud: true});
                    """.trimIndent()
                }
            }
        }
    }
}