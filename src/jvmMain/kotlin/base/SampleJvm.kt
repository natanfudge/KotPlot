package base

import models.*
import java.awt.Desktop
import java.io.File

actual class Sample {
    actual fun checkMe() = 42
}

actual object Platform {
    actual val name: String = "JVM"
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

fun main() {
    val points = listOf(Point(0, 0), Point(1, 1), Point(2, 2))

    val plot = KotPlot.plot {
        trace(points = points, mode = TraceMode.`lines+markers`)

        layout(
            xAxis = Axis(title = "My x values"),
            yAxis = Axis(title = "My y values")
        )

    }

    plot.makeFile()

}

