package sample

expect class Sample() {
    fun checkMe(): Int
}

expect object Platform {
    val name: String
}

fun hello(): String = "Hello from ${Platform.name}"


///**
// * Create a standalone html with the page
// * @param file the reference to html file. If null, create a temporary file
// * @param show if true, start the browser after file is created
// */
//fun PlotGrid.makeFile(file: File? = null, show: Boolean = true) {
//    val actualFile = file ?: File.createTempFile("tempPlot", ".html")
//    actualFile.writeText(makeHtml())
//    if (show) {
//        Desktop.getDesktop().browse(actualFile.toURI())
//    }
//}

class PlotGrid