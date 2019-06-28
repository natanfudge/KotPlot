package base


import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import constructables.Color
import org.junit.Test
import kotlin.test.assertEquals

class ColorSerializationTests {

    val json = Json(JsonConfiguration.Stable)

    @Serializable
    class Wrapper(val color: Color)

//    object Serializer : InlineSerializer<Inlined>(Inlined::class)
//
//    @Serializable(Serializer::class)
//    class Inlined(val str: String)

    @Test
    fun `String is in the form rgb(red, green, blue)`() {
        val obj = Color(1, 2, 3)
        val str = json.stringify(Color.serializer(), obj)
        assertEquals("\"rgb(1, 2, 3)\"", str)
    }

    @Test
    fun `String  is in the form rgb(red, green, blue) in composite object`() {
        val obj = Wrapper(Color(1, 2, 3))
        val str = json.stringify(Wrapper.serializer(), obj)
        assertEquals("{\"color\":\"rgb(1, 2, 3)\"}", str)
    }
//
//
//    object DataSerializer : InlineSerializer<InlinedDataclass>(InlinedDataclass::class)
//    @Serializable(DataSerializer::class)
//    data class InlinedDataclass(val str: String)
//
//    @Test
//    fun `String is inlined even in dataclass`() {
//        val obj = InlinedDataclass("test")
//        val str = json.stringify(InlinedDataclass.serializer(), obj)
//        assertEquals("\"test\"", str)
//    }
}