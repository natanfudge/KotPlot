package models.internal

import models.Plot

internal data class PlotCell(
    val plot: Plot,
    val rowNumber: Int,
    val size: Int?,
    val column: Int
) {
    init {
        if (size != null && size !in 0..12) throw IllegalArgumentException("Size $size should be in range 0..12")
    }
}