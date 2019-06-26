package models

import kotlinx.serialization.Serializable

@Serializable
data class Layout(val title: String = "Untitled models", val xAxis: Axis, val yAxis: Axis)