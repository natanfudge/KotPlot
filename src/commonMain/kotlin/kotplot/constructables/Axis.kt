package kotplot.constructables

import kotlinx.serialization.Serializable
import kotplot.temp.AxisTypeSerializer
import kotplot.temp.SerialEnum


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
enum class AxisType(override val serialName: String?) : SerialEnum {
    /**
     * Points on the axis will be distributed evenly on the range.
     */
    Linear("linear"),
    /**
     * Values will be interpreted as their natural log (ln). Useful for large numbers.
     */
    Log("log"),

    /**
     * Values will be interpreted as dates.
     */
    Date("date"),

    /**
     * Each possible value will be represnted on the axis
     */
    Category("category"),

    /**
     * Purpose unclear. If you know the purpose of this please make an issue.
     */
    MultiCategory("multicategory");
}

