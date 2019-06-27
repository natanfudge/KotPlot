package builders

import models.*

/**
 * @param responsive By setting plotly.js config to { responsive: true }, plots will be resized upon changing the size of the window.
 * This is especially useful for mobile devices switching from portrait to landscape.
 * @param showSendToCloud Shows the "Edit in chart studio" button
 * @param init Call [scatterTrace][Plot2DBuilder.scatterTrace] to put traces and [layout][Plot2DBuilder.layout] to configure the layout.
 */
fun kotPlot(responsive: Boolean = true, showSendToCloud: Boolean = true, init: Plot2DBuilder.() -> Unit): Plot2D =
    Plot2DBuilder(responsive, showSendToCloud).apply(init).build()




