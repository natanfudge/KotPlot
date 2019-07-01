package doc

import kotplot.builders.KotPlot
import kotplot.constructables.Point
import kotplot.jvmExtensions.show
import kotplot.toHtml

//TODO: change README to html so I can have tabs for jvm/js/native, and kotlin-dsl/groovy-dsl
fun main() {
    val points = listOf(
        Point(0, 0),
        Point(1, 1),
        Point(2, 2)
    )

    val plot = KotPlot.plot {
        scatterTrace(points)
    }

    print(plot.toHtml())

    plot.show()
}