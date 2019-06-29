package jvmExtensions

import models.Plot
import models.PlotGrid
import toHtml
import java.awt.Desktop
import java.io.File

/**
 * Create a standalone html with the page
 * @param file the reference to html file. If null, create a temporary file
 * @param show if true, start the browser after file is created
 */
fun Plot.show(file: File? = null, show: Boolean = true) {
    val actualFile = file ?: File.createTempFile("tempPlot", ".html")
    actualFile.writeText(this.toHtml())
    if (show) {
        Desktop.getDesktop().browse(actualFile.toURI())
    }
}

/**
 * Create a standalone html with the page
 * @param file the reference to html file. If null, create a temporary file
 * @param show if true, start the browser after file is created
 */
fun PlotGrid.show(file: File? = null, show: Boolean = true) {
    val actualFile = file ?: File.createTempFile("tempPlot", ".html")
    actualFile.writeText(this.toHtml())
    if (show) {
        Desktop.getDesktop().browse(actualFile.toURI())
    }
}