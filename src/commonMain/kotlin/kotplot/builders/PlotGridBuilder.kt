package kotplot.builders

import kotplot.models.internal.PlotCell
import kotplot.constructables.PlotConfig
import kotplot.models.PlotGrid

class PlotGridBuilder internal constructor(private val title: String) : Builder() {
    private val cells: MutableList<PlotCell> = mutableListOf()
    internal fun build() = PlotGrid(title, cells)

    /**
     * @param row If you specify multiple cells with different row values,
     * the ones with lower rows will be displayed bellow the ones with higher row values.
     * By default plots will be ordered by the order you created them.
     * @param size A value between 1 and 12. Putting 1 or 2 is not recommended.
     * 3 means 3/12 of the row, 4 means 4/12 of the row, etc. 12 means it will take the entire row.
     * If the total size exceeds 12 then plots will be drawn on a new row automatically.
     * Put null if you want the plots to spread evenly on one line, but don't put more than 5 plots in one row in that case.
     * @param column If you specify multiple cells with different column values,
     * the ones with lower column will be displayed to the left of the ones with higher column values.
     * By default plots will be ordered from left to right by the order you created them.
     * @param plot Configure just like [KotPlot.plot]
     */
    fun plotCell(
        config: PlotConfig = PlotConfig(),
        row: Int = Int.MAX_VALUE,
        size: Int? = null,
        column: Int = Int.MAX_VALUE,
        plot: Plot2DBuilder.() -> Unit
    ) {
        cells.add(PlotCell(KotPlot.plot(config, plot), row, size, column))
    }
}
