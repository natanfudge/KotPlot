package models

import models.internal.PlotCell

data class PlotGrid internal constructor(val title: String, internal val cells: List<PlotCell>)

