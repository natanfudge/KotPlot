package builders

import models.PlotCell
import models.PlotConfig
import models.PlotGrid

class PlotGridBuilder internal constructor(private val title : String ) : Builder<PlotGrid>(){
    private val cells : MutableList<PlotCell> = mutableListOf()
    override fun build() = PlotGrid(title,cells)

    /**
     * @param id The HTML-DOM id of the created plot.
     * @param row If you specify multiple cells with different row values
     * the ones with lower rows will be displayed bellow the ones with higher row values.
     * @param size A value between 1 and 12. Putting 1 or 2 is not recommended.
     * 3 means 3/12 of the row, 4 means 4/12 of the row, etc. 12 means it will take the entire row.
     * If the total size exceeds 12 then plots will be drawn on a new row automatically.
     * Put null if you want the plots to spread evenly on one line, but don't put more than 5 plots in one row in that case.
     *
     */
    fun plotCell(
        config:PlotConfig = PlotConfig(),
        row: Int = 1,
        size: Int? = null,
        colOrderNumber: Int = Int.MAX_VALUE,
//        id: String = "plot",
        plots: Plot2DBuilder.() -> Unit
    ) {
        val plot = KotPlot.plot (config,plots)
        cells.add(PlotCell(plot, row, size, colOrderNumber))
    }
}
