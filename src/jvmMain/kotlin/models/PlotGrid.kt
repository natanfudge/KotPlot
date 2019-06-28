package models

//TODO: figure out defaults
data class PlotCell(
    val plot: Plot2D,
    val plotId: String?,
    val rowNumber: Int,
    val size: Int,
    val colOrderNumber: Int
) {
    init {
        //TODO configure this
        if (size !in 0..100) throw IllegalArgumentException("Size $size should be in range 0..100")
    }
}

data class PlotGrid internal constructor(val title: String,  val cells: List<PlotCell>)

//TODO: seperate internal and api