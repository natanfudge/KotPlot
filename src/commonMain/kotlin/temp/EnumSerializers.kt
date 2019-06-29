package temp

import builders.Shape
import builders.Symbol
import constructables.AxisType
import kotlinx.serialization.internal.CommonEnumSerializer
import models.internal.TraceMode
import models.internal.TraceType

internal object TraceModeSerializer : CommonEnumSerializer<TraceMode>(
    "TraceMode",
    TraceMode.values(),
    TraceMode.values().serial()
)

internal object SymbolSerializer : CommonEnumSerializer<Symbol>(
    "TraceMode",
    Symbol.values(),
    Symbol.values().serial()
)

internal object ShapeSerializer : CommonEnumSerializer<Shape>(
    "TraceMode",
    Shape.values(),
    Shape.values().serial()
)

internal object TraceTypeSerializer : CommonEnumSerializer<TraceType>(
    "TraceMode",
    TraceType.values(),
    TraceType.values().serial()
)

internal object AxisTypeSerializer : CommonEnumSerializer<AxisType>(
    "TraceMode",
    AxisType.values(),
    AxisType.values().serial()
)


