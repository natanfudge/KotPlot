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


    /**
     * Creates multiple plots.
     * @param title This will be the title of the page on the JVM version. TODO: make it jvm only...
     * @param init Call [plotCell][PlotGridBuilder.plotCell] here to add plots in a similar way to [KotPlot.plot].
     * It's recommended to only put up to 6 plots in each row, otherwise the plots might get 'smushed'.
     */
    fun plotGrid(title: String = "", init: PlotGridBuilder.() -> Unit): PlotGrid =
        PlotGridBuilder(title).apply(init).build()


}



