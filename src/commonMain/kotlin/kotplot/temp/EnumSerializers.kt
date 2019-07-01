package kotplot.temp

import kotplot.builders.Shape
import kotplot.builders.Symbol
import kotplot.constructables.AxisType
import kotlinx.serialization.internal.CommonEnumSerializer
import kotplot.models.internal.TraceMode
import kotplot.models.internal.TraceType

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


