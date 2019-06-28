package builders

import models.*

object KotPlot {
    /**
     * Creates a new plot.
     * @param init Call [scatterTrace][Plot2DBuilder.scatterTrace] to put traces and [layout][Plot2DBuilder.layout] to configure the layout.
     */
    fun plot(config: PlotConfig = PlotConfig(), init: Plot2DBuilder.() -> Unit): Plot2D =
        Plot2DBuilder(config).apply(init).build()


    fun plotGrid(title: String = "", init: PlotGridBuilder.() -> Unit): PlotGrid =
        PlotGridBuilder(title).apply(init).build()


}



