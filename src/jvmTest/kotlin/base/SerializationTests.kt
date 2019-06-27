package base

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import org.junit.Test
import temp.InlineSerializer
import kotlin.test.assertEquals

class SerializationTests {

    val json = Json(JsonConfiguration.Stable)

    @Serializable
    class Wrapper(val inlined: Inlined)

    object Serializer : InlineSerializer<Inlined>(Inlined::class)

    @Serializable(Serializer::class)
    class Inlined(val str: String)

    @Test
    fun `String is inlined`() {
        val obj = Inlined("test")
        val str = json.stringify(Inlined.serializer(), obj)
        assertEquals("\"test\"", str)
    }

    @Test
    fun `String is inlined in composite object`() {
        val obj = Wrapper(Inlined("test"))
        val str = json.stringify(Wrapper.serializer(), obj)
        assertEquals("{\"inlined\":\"test\"}", str)
    }


    object DataSerializer : InlineSerializer<InlinedDataclass>(InlinedDataclass::class)
    @Serializable(DataSerializer::class)
    data class InlinedDataclass(val str: String)

    @Test
    fun `String is inlined even in dataclass`() {
        val obj = InlinedDataclass("test")
        val str = json.stringify(InlinedDataclass.serializer(), obj)
        assertEquals("\"test\"", str)
    }
}