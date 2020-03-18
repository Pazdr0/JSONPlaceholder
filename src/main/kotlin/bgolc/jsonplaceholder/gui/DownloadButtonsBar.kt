package bgolc.jsonplaceholder.gui

import bgolc.jsonplaceholder.model.Comment
import bgolc.jsonplaceholder.model.Post
import bgolc.jsonplaceholder.utils.Reader
import com.google.gson.reflect.TypeToken
import javafx.event.EventHandler
import javafx.scene.control.Button
import javafx.scene.layout.HBox
import javafx.scene.layout.Priority
import java.lang.reflect.Type

class DownloadButtonsBar(reader: Reader) : HBox() {

    private val postDownloadButton = Button("Pobierz posty")
        .apply {
            maxWidth = Double.MAX_VALUE
            val type: Type = object : TypeToken<List<Post>>() {}.type
            onAction = EventHandler { reader.readFile("https://jsonplaceholder.typicode.com/posts", type) }
        }
    private val commentDownloadButton = Button("Pobierz komentarze")
        .apply {
            maxWidth = Double.MAX_VALUE
            val type: Type = object : TypeToken<List<Comment>>() {}.type
            onAction = EventHandler { reader.readFile("https://jsonplaceholder.typicode.com/comments", type) }
        }
    private val albumsDownloadButton = Button("Pobierz albumy")
        .apply {
            maxWidth = Double.MAX_VALUE
            isDisable = true
        }
    private val photosDownloadButton = Button("Pobierz zdjęcia")
        .apply {
            maxWidth = Double.MAX_VALUE
            isDisable = true
        }
    private val todosDownloadButton = Button("Pobierz TODOs")
        .apply {
            maxWidth = Double.MAX_VALUE
            isDisable = true
        }
    private val usersDownloadButton = Button("Pobierz użytkowników")
        .apply {
            maxWidth = Double.MAX_VALUE
            isDisable = true
        }

    init {
        setHgrow(postDownloadButton, Priority.ALWAYS)
        setHgrow(commentDownloadButton, Priority.ALWAYS)
        setHgrow(albumsDownloadButton, Priority.ALWAYS)
        setHgrow(photosDownloadButton, Priority.ALWAYS)
        setHgrow(todosDownloadButton, Priority.ALWAYS)
        setHgrow(usersDownloadButton, Priority.ALWAYS)

        children.addAll(
            postDownloadButton,
            commentDownloadButton,
            albumsDownloadButton,
            photosDownloadButton,
            todosDownloadButton,
            usersDownloadButton
        )
    }
}