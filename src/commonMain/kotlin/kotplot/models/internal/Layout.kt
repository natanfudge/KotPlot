package kotplot.models.internal

import kotplot.constructables.Axis
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class Layout(
    val title: String,
    @SerialName("xaxis")
    val xAxis: Axis,
    @SerialName("yaxis")
    val yAxis: Axis
)