package sample

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
fun PlotGrid.makeFile(file: File? = null, show: Boolean = true) {
    val actualFile = file ?: File.createTempFile("tempPlot", ".html")
    actualFile.writeText(makeHtml())
    if (show) {
        Desktop.getDesktop().browse(actualFile.toURI())
    }
}