package models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import temp.EnumSerialNameSerializer

@Serializable
data class LineType(val shape: Shape)

object ShapeDeserializer : EnumSerialNameSerializer<Shape>(Shape::class)

@Serializable(ShapeDeserializer::class)
enum class Shape {
    /**
     * The line will go horizontally towards the next point and then vertically towards it in a straight line.
     */
    @SerialName("hv")
    HorizontalThenVertical,
    @SerialName("vh")
    /**
     * The line will go vertically towards the next point and then horizontally towards it in a straight line.
     */
    VerticalThenHorizontal,
    @SerialName("hvh")
    /**
     * The line will go half way horizontally towards the next point, and then vertically all the way towards it,
     * and then it will go the other half horizontally towards it in a straight line.
     */
    HorizontalThenVerticalThenHorizontal,
    @SerialName("vhv")
    /**
     * The line will go half way vertically towards the next point, and then horizontally all the way towards it,
     * and then it will go the other half vertically towards it in a straight line.
     */
    VerticalThenHorizontalThenVertical,
    @SerialName("spline")
    /**
     * The line will go towards the next point in a curved way.
     */
    Curved,
    /**
     * The line will be a straight line between two points.
     */
    Linear
}

