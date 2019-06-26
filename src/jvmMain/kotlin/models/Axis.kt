package models

import kotlinx.serialization.Serializable

//TODO: figure out the proper default for null values
@Serializable
data class Axis(
    val title: String? = null,
    val type: AxisType = AxisType.`-`,
    val visible: Boolean = true,
    val autoRange: Boolean = true,
    val range: ClosedRange<Double>? = null,
    val color : String? = null
)

enum class AxisType {
//    @JsName("default")
    `-`,
    linear,
    log,
    date,
    category,
    multicategory;
}

