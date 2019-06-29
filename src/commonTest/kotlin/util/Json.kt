package util

import kotlinx.serialization.SerializationStrategy
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration

internal fun <T>stringify(serializer : SerializationStrategy<T>, obj : T) = Json(JsonConfiguration.Stable).stringify(serializer,obj)