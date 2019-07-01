package kotplot.models

import kotplot.constructables.PlotConfig
import kotlinx.serialization.Serializable
import kotplot.models.internal.Layout
import kotplot.models.internal.Trace

@Serializable
data class Plot internal constructor(
    internal val data: List<Trace> = listOf(),
    internal val layout: Layout,
    val config: PlotConfig
)

