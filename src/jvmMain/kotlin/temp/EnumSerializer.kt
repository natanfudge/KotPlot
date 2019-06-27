package temp

import kotlinx.serialization.*
import kotlinx.serialization.internal.StringDescriptor
import kotlin.reflect.KClass

fun <E : Enum<E>> EnumShit(kClass: KClass<E>): KSerializer<E> = EnumSerialNameSerializer(kClass)

open class EnumSerialNameSerializer<E : Enum<E>>(
    private val kClass: KClass<E>
) : KSerializer<E> {
    override val descriptor: SerialDescriptor = StringDescriptor

    override fun serialize(encoder: Encoder, obj: E) {
        val value = obj.javaClass.getField(obj.name).getAnnotation(SerialName::class.java)?.value
        encoder.encodeString(value ?: obj.name)
    }

    override fun deserialize(decoder: Decoder): E =
        decoder.decodeString().let { value ->
            kClass.enumMembers()
                .firstOrNull { it.getEnumFieldAnnotation<SerialName>()?.value == value }
                ?: run {
                    throw SerializationException("Could not serialize class $kClass. There are no enum members.")
                }
        }
}

inline fun <reified A : Annotation> Enum<*>.getEnumFieldAnnotation(): A? =
    javaClass.getDeclaredField(name).getAnnotation(A::class.java)