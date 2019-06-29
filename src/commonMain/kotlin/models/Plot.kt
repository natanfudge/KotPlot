package models

import constructables.PlotConfig
import kotlinx.serialization.Serializable
import models.internal.Layout
import models.internal.Trace

@Serializable
data class Plot internal constructor(
    internal val data: List<Trace> = listOf(),
    internal val layout: Layout?,
    val config: PlotConfig
)

