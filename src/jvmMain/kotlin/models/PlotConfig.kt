package models

import kotlinx.serialization.Serializable

@Serializable
class PlotConfig internal constructor( val responsive : Boolean,val showSendToCloud : Boolean)