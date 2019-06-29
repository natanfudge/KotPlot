package models.internal

import builders.Shape
import kotlinx.serialization.Serializable

@Serializable
internal data class LineType(val shape: Shape)



