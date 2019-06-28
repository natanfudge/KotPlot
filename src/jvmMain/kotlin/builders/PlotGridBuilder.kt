package builders

import models.Plot2D
import models.PlotCell
import models.PlotConfig
import models.PlotGrid

class PlotGridBuilder internal constructor(private val title : String ) : Builder<PlotGrid>(){
    private val cells : MutableList<PlotCell> = mutableListOf()
    override fun build() = PlotGrid(title,cells)

    /**
     * @param id The HTML-DOM id of the created plot.
     */
    fun plotCell(
        config:PlotConfig = PlotConfig(),
        rowNumber: Int = Int.MAX_VALUE,
        size: Int = 0,
        colOrderNumber: Int = Int.MAX_VALUE,
        id: String? = null,
        plots: Plot2DBuilder.() -> Unit
    ) {
        val plot = KotPlot.plot (config,plots)
        cells.add(PlotCell(plot, id, rowNumber, size, colOrderNumber))
    }
}
