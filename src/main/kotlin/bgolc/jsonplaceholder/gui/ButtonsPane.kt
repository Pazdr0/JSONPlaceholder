package bgolc.jsonplaceholder.gui

import bgolc.jsonplaceholder.utils.JsonService
import javafx.geometry.Insets
import javafx.scene.layout.VBox

class ButtonsPane : VBox() {

    private val service = JsonService()

    init {
        padding = Insets(20.0, 10.0, 30.0, 10.0)
        children.addAll(
            DownloadButtonsBar(service),
            ActionButtonsBar(service)
        )
    }
}



