package kotplot.models

import kotplot.models.internal.PlotCell

data class PlotGrid internal constructor(val title: String, internal val cells: List<PlotCell>)

