package models

import kotlinx.serialization.Serializable

@Serializable
data class Line(val shape: Shape)

enum class Shape {
    hv,
    vh,
    hvh,
    vhv,
    spline,
    linear
}

