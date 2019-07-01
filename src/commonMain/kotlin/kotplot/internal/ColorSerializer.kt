package kotplot.internal

import kotlinx.serialization.*
import kotlinx.serialization.internal.StringDescriptor
import kotplot.constructables.Color

internal object ColorSerializer : KSerializer<Color> {
    override val descriptor: SerialDescriptor = StringDescriptor.withName("Color")

    override fun serialize(encoder: Encoder, obj: Color) {
        encoder.encodeString("rgb(${obj.red}, ${obj.green}, ${obj.blue})")
    }

    override fun deserialize(decoder: Decoder): Color {
        throw SerializationException("Deserializing a string into a color is not supported.")
    }

}