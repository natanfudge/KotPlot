package constructables

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import temp.AxisTypeSerializer



@Serializable
data class Axis internal constructor(
    val color: Color,
    val title: String,
    val type: AxisType,
    val visible: Boolean,
    val range: List<Double>?
) {
    /**
     * @param color Color of the title and the numbers on the axis
     * @param title Text that will be displayed next to the axis
     * @param visible
     * @param range The range of points that will be displayed by default. Set to null to make range automatic.
     */
    constructor(
        color: Color = Color.Black,
        title: String = "",
        type: AxisType = AxisType.Linear,
        visible: Boolean = true,
        range: ClosedRange<Double>? = null
    ) : this(
        color,
        title,
        type,
        visible,
        if (range == null) null else listOf(range.start, range.endInclusive)
    )
}


@Serializable(AxisTypeSerializer::class)
enum class AxisType {
    /**
     * Points on the axis will be distributed evenly on the range.
     */
    @SerialName("linear")
    Linear,
    /**
     * Values will be interpreted as their natural log (ln). Useful for large numbers.
     */
    @SerialName("log")
    Log,

    /**
     * Values will be interpreted as dates.
     */
    @SerialName("date")
    Date,

    /**
     * Each possible value will be represnted on the axis
     */
    @SerialName("category")
    Category,

    /**
     * Purpose unclear. If you know the purpose of this please make an issue.
     */
    @SerialName("multicategory")
    MultiCategory;
}

