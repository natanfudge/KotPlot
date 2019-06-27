package models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import temp.EnumSerialNameSerializer

@Serializable
data class LineType(val shape: Shape)

object ShapeDeserializer : EnumSerialNameSerializer<Shape>(Shape::class)

@Serializable(ShapeDeserializer::class)
enum class Shape {
    @SerialName("hv")
    HorizontalThenVertical,
    @SerialName("vh")
    VerticalThenHorizontal,
    hvh,
    vhv,
    spline,
    linear
}

