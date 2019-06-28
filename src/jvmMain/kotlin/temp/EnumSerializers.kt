package temp

import models.AxisType
import models.Symbol
import models.TraceMode
import models.TraceType

internal object TraceModeSerializer : EnumSerialNameSerializer<TraceMode>(TraceMode::class)
internal object SymbolSerializer : EnumSerialNameSerializer<Symbol>(Symbol::class)
internal object TraceTypeSerializer : EnumSerialNameSerializer<TraceType>(TraceType::class)
internal  object AxisTypeSerializer : EnumSerialNameSerializer<AxisType>(AxisType::class)