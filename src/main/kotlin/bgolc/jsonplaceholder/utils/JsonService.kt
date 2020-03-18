package bgolc.jsonplaceholder.utils

import bgolc.jsonplaceholder.model.DownloadableContent
import javafx.application.Platform
import javafx.scene.control.Alert
import java.io.File
import java.io.FileNotFoundException
import java.lang.reflect.Type
import java.nio.file.Path
import java.nio.file.Paths

class JsonService : Reader, Writer {

    private val reader = JsonReader()
    private val writer = JsonWriter()
    private lateinit var jsonList: List<DownloadableContent>
    private lateinit var destination: Path

    override fun readFile(stringUrl: String, type: Type) {
        try {
            jsonList = reader.readJsonFromUrl(stringUrl, type)
        } catch (ex: Exception) {
            Platform.runLater {
                Alert(Alert.AlertType.ERROR, "Wprowadzono nieporawny adres url").showAndWait()
            }
        }
    }

    override fun setDestiantion(file: File?) {
        if (file != null) {
            destination = Paths.get(file.absolutePath)
        } else {
            Platform.runLater {
                Alert(Alert.AlertType.ERROR, "Wprowadzono nieprawidłową ścieżkę").showAndWait()
            }
        }
    }

    override fun saveFiles() {
        try {
            writer.writeJsons(destination, jsonList)
        } catch (ex: UninitializedPropertyAccessException) {
            Alert(Alert.AlertType.ERROR, "Nie pobrano danych lub nie wybrano ścieżki do zapisu").showAndWait()
        } catch (ex: FileNotFoundException) {
            Alert(Alert.AlertType.ERROR, ex.message).showAndWait()
        } catch (ex: IllegalStateException) {
            Alert(Alert.AlertType.ERROR, ex.message).showAndWait()
        }
    }
}

interface Reader {
    fun readFile(stringUrl: String, type: Type)
}

interface Writer {
    fun setDestiantion(file: File?)
    fun saveFiles()
}
