package models

import kotlinx.serialization.Serializable

@Serializable
class Plot2D internal constructor(val data: List<Trace> = listOf(), val layout: Layout)