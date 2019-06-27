package models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Layout internal constructor(val title: String,
                  @SerialName("xaxis")
                  val xAxis: Axis,
                  @SerialName("yaxis")
                  val yAxis: Axis)