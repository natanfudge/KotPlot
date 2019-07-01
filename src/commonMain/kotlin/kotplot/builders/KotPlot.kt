package kotplot.builders

import kotplot.constructables.PlotConfig
import kotplot.models.Plot
import kotplot.models.PlotGrid

object KotPlot {
    /**
     * Creates a new plot.
     * @param init Call [scatterTrace][Plot2DBuilder.scatterTrace] to add a trace and [layout][Plot2DBuilder.layout] to configure the layout.
     */
    fun plot(config: PlotConfig = PlotConfig(), init: Plot2DBuilder.() -> Unit): Plot =
        Plot2DBuilder(config).apply(init).build()


    fun plotGrid(title: String = "", init: PlotGridBuilder.() -> Unit): PlotGrid =
        PlotGridBuilder(title).apply(init).build()


}



