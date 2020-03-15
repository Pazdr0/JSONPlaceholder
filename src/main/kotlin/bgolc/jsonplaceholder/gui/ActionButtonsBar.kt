package bgolc.jsonplaceholder.gui

import bgolc.jsonplaceholder.utils.Writer
import javafx.event.EventHandler
import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.control.Button
import javafx.scene.layout.HBox
import javafx.scene.layout.Priority
import javafx.stage.DirectoryChooser

class ActionButtonsBar(writer: Writer) : HBox() {

    private val buttonWidth = 150.0
    private val chooseDestinationButton = Button("Wybierz lokalizację")
        .apply {
            maxWidth = buttonWidth
            onAction = EventHandler {
                val chooser = DirectoryChooser().showDialog(scene.window)
                writer.getDestiantion(chooser.absolutePath)
            }
        }
    private val saveJsonsButton = Button("Zapisz pliki")
        .apply {
            maxWidth = buttonWidth
            onAction = EventHandler { writer.saveFiles() }
        }

    init {
        alignment = Pos.CENTER
        padding = Insets(10.0, 0.0, 0.0, 0.0)

        setHgrow(chooseDestinationButton, Priority.ALWAYS)
        setHgrow(saveJsonsButton, Priority.ALWAYS)

        children.addAll(chooseDestinationButton, saveJsonsButton)
    }
}