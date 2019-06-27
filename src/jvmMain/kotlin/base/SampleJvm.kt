package base

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import models.*
import temp.EnumSerialNameSerializer
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
    val points2 = listOf(Point(1, 1), Point(1, 1), Point(2, 2))

    val plot = KotPlot.plot {
        scatterTrace(points = points, mode = TraceMode.Lines)
//        scatterTrace(points = points2, mode = TraceMode.`lines+markers`)

        layout(
            xAxis = Axis(title = "My x values"),
            yAxis = Axis(title = "My y values")
        )

    }
    val json = Json(JsonConfiguration.Stable)
    println(json.stringify(Trace.serializer(),plot.data[0]))


//    println(json.stringify(Wrapper.serializer(), Wrapper(Test.Foo)))
    plot.makeFile()

}

@Serializable
class Wrapper(val test: Test)

object TestSerializer : EnumSerialNameSerializer<Test>(Test::class)

@Serializable(with = TestSerializer::class)
enum class Test {
    @SerialName("Bar") // Will be serialized to "Bar"
    Foo
}