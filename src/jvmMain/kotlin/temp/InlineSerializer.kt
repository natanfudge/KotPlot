package temp

import kotlinx.serialization.*
import kotlinx.serialization.internal.StringDescriptor
import kotlin.reflect.KClass
import kotlin.reflect.full.IllegalCallableAccessException
import kotlin.reflect.full.memberProperties

/**
 * Inlines a class with a singular property into that property for type safety.
 * Example: `class Inlined(val str : String)`
 * usually becomes `{str: "thevalue"}`
 * but if you do:
 * ```
 * private object ExampleSerializer : InlineSerializer<Inlined>(Inlined::class)
 * @Serializerable(ExamplerSerializer::class)
 * class Inlined(val str : String)
 *  ```
 * It will become just `"thevalue"`
 */
internal open class InlineSerializer<T : Any>(private val kClass: KClass<T>) : KSerializer<T> {
    override val descriptor: SerialDescriptor = StringDescriptor

    override fun serialize(encoder: Encoder, obj: T) {
        val properties = kClass.memberProperties
        if (properties.size != 1) throw SerializationException("InlineSerializer must be used on a class with exactly one property! Class $kClass has ${properties.size}: $properties")
        val field = properties.first()
        val value : String
        try {
            value = field.get(obj) as? String
                ?: throw SerializationException("InlineSerializer must be used on a class of which the first field is a string!")

        } catch (e : IllegalCallableAccessException){
            throw SerializationException("InlineSerializer must be used on a class of which the inlined property is public!")
        }
        encoder.encodeString(value)
    }

    override fun deserialize(decoder: Decoder): T {
        val string = decoder.decodeString()
        val constructors = kClass.constructors
        if (constructors.isEmpty()) throw SerializationException("InlineSerializer must be used on a class of which there is a constructor that accepts the inlined type!")
        return constructors.first().call(string)

    }

}