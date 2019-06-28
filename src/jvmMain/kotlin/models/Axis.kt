package models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import temp.AxisTypeSerializer

//TODO: figure out the proper default for null values
@Serializable
data class Axis(
    /**
     *
     */
    val title: String? = null,
    val type: AxisType = AxisType.Linear,
    val visible: Boolean = true,
    val autoRange: Boolean = true,
    val range: ClosedRange<Double>? = null,
    val color : String? = null
)

@Serializable(AxisTypeSerializer::class)
enum class AxisType {
    /**
     * Points on the axis will be distributed evenly.
     */
    @SerialName("linear")
    Linear,
    /**
     * Values will be interpreted as their natural log (ln). Useful for large numbers.
     */
    @SerialName("log")
    Log,
    @SerialName("date")
    /**
     * Values will be interpreted as dates.
     */
    Date,
    @SerialName("category")
    /**
     * Each possible value will be represnted on the axis
     */
    Category,

    /**
     * Purpose unclear. If you know the purpose of this please make an issue.
     */
    @SerialName("multicategory")
    MultiCategory;
}

