package kotplot.jvmExtensions

import kotplot.models.Plot
import kotplot.models.PlotGrid
import kotplot.toHtml
import java.awt.Desktop
import java.io.File

/**
 * Shows the plot on a browser
 * @param file the reference to html file. If null, create a temporary file
 */
fun Plot.show(file: File? = null) {
    val actualFile = file ?: File.createTempFile("tempPlot", ".html")
    actualFile.writeText(this.toHtml())
    Desktop.getDesktop().browse(actualFile.toURI())
}

/**
 * Shows the plot on a browser
 * @param file the reference to html file. If null, create a temporary file
 */
fun PlotGrid.show(file: File? = null) {
    val actualFile = file ?: File.createTempFile("tempPlot", ".html")
    actualFile.writeText(this.toHtml())
    Desktop.getDesktop().browse(actualFile.toURI())
}