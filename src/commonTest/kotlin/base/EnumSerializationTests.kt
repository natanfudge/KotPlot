package base

import kotlinx.serialization.Serializable
import kotlinx.serialization.internal.CommonEnumSerializer
import temptemp.SerialEnum
import temptemp.serial
import util.stringify
import kotlin.test.Test
import kotlin.test.assertEquals


class EnumSerializationTests {

    @Serializable
    class Wrapper(val test: TestEnum)

    object TestSerializer :
        CommonEnumSerializer<TestEnum>("TestEnum", TestEnum.values(), TestEnum.values().serial())

    @Serializable(with = TestSerializer::class)
    enum class TestEnum(override val serialName: String? = null) : SerialEnum {
        Foo("Bar"), // Will be serialized to "Bar"
        AnotherConstant // Will be serialized to "AnotherConstant"
    }

    


    @Test
    fun `Enum gets serialized to its serial name when specified`() {
        val wrapper = Wrapper(TestEnum.Foo)
        assertEquals("{\"test\":\"Bar\"}", stringify(Wrapper.serializer(), wrapper))
    }

    @Test
    fun `Enum gets serialized to its variable name when there is no serial name`() {
        val wrapper = Wrapper(TestEnum.AnotherConstant)
        assertEquals("{\"test\":\"AnotherConstant\"}", stringify(Wrapper.serializer(), wrapper))
    }
}