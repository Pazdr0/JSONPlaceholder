package bgolc.jsonplaceholder.gui

import javafx.geometry.Pos
import javafx.scene.control.Label
import javafx.scene.layout.BorderPane
import javafx.scene.layout.VBox

class MainPane : BorderPane() {

    init {
        center = InfoPane()
        bottom = ButtonsPane()
    }
}

class InfoPane : VBox() {

    init {
        alignment = Pos.CENTER
        children.addAll(
            Label("1. Wybierz plik do pobrania"),
            Label("2. Wybierz lokalizację do zapisu"),
            Label("3. Zapisz pliki")
        )
    }
}

