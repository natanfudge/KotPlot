package models

import base.InvalidPlotException
import kotlinx.serialization.*
import kotlinx.serialization.internal.StringDescriptor

private const val MinimumColorValue = 0
private const val MaximumColorValue = 255

@Serializable(ColorSerializer::class)
class Color(val red: Int, val green: Int, val blue: Int) {

    init {
        validateColorValue(red, "red")
        validateColorValue(green, "green")
        validateColorValue(blue, "blue")
    }

    private fun validateColorValue(colorValue: Int, colorName: String) {
        if (colorValue < MinimumColorValue || colorValue > MaximumColorValue)
            throw InvalidPlotException("A color's $colorName value must be within the bounds 0..255. This color has a $colorName of $colorValue.")
    }

    companion object{
        val Black = Color(0,0,0)
        val Red = Color(255,0,0)
        val Green = Color(0,255,0)
        val Blue = Color(0,0,250)
        val Yellow = Color(255,255,0)
        val brown = Color(165,42,42)
        val Cyan = Color(0,255,255)
        val Gold = Color(255,215,0)
        val Gray = Color(128,128,128)
        val Maroon = Color(128,0,0)
        val Orange = Color(255,165,0)
        val Pink = Color(255,192,203)
        val Purple = Color(128,0,128)
        val White = Color(255,255,255)

    }

}



internal object ColorSerializer : KSerializer<Color> {
    override val descriptor: SerialDescriptor = StringDescriptor.withName("Color")

    override fun serialize(encoder: Encoder, obj: Color) {
        encoder.encodeString("rgb(${obj.red}, ${obj.green}, ${obj.blue})")
    }

    override fun deserialize(decoder: Decoder): Color {
        throw SerializationException("Deserializing a string into a color is not supported.")
    }

}