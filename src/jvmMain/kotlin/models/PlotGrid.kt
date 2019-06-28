package models

//TODO: figure out defaults
data class PlotCell internal constructor(
    val plot: Plot2D,
//    val plotId: String?,
    val rowNumber: Int,
    val size: Int?,
    val colOrderNumber: Int
) {
    init {
        if (size != null && size !in 0..12) throw IllegalArgumentException("Size $size should be in range 0..12")
    }
}

data class PlotGrid internal constructor(val title: String, val cells: List<PlotCell>)

//TODO: seperate internal and api