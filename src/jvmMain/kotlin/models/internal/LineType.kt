package models.internal

import builders.Shape
import kotlinx.serialization.Serializable
import temp.EnumSerialNameSerializer

@Serializable
internal data class LineType(val shape: Shape)



