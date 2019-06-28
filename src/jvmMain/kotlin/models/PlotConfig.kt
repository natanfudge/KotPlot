package models

import kotlinx.serialization.Serializable

@Serializable
data class PlotConfig(
    /** Plots will be resized upon changing the size of the window.
     * This is especially useful for mobile devices switching from portrait to landscape.
     * */
    val responsive: Boolean = true,
    /**
     * Shows the "Edit in chart studio" button
     */
    val showSendToCloud: Boolean = true
)