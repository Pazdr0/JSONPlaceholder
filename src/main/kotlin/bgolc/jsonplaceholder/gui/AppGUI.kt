package bgolc.jsonplaceholder.gui

import javafx.application.Application
import javafx.scene.Scene
import javafx.stage.Stage

class AppGUI : Application() {

    override fun start(stage: Stage) {
        stage.title = "JSONPlaceholder"
        stage.scene = Scene(MainPane(), 800.0, 600.0)
        stage.show()
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            launch(AppGUI::class.java)
        }
    }
}