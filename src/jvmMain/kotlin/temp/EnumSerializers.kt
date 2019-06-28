package temp

import builders.Shape
import builders.Symbol
import constructables.AxisType
import models.internal.TraceMode
import models.internal.TraceType

internal object TraceModeSerializer : EnumSerialNameSerializer<TraceMode>(TraceMode::class)
internal object SymbolSerializer : EnumSerialNameSerializer<Symbol>(Symbol::class)
internal object TraceTypeSerializer : EnumSerialNameSerializer<TraceType>(TraceType::class)
internal  object AxisTypeSerializer : EnumSerialNameSerializer<AxisType>(AxisType::class)
internal object ShapeDeserializer : EnumSerialNameSerializer<Shape>(Shape::class)