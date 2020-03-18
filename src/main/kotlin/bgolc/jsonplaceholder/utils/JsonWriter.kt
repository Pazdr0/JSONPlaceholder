package bgolc.jsonplaceholder.utils

import bgolc.jsonplaceholder.model.DownloadableContent
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import java.io.FileNotFoundException
import java.io.FileWriter
import java.nio.file.Files
import java.nio.file.Path


internal class JsonWriter {

    private val gson = GsonBuilder()
        .setPrettyPrinting()
        .create()

    private companion object {
        const val EXT = ".json"
    }

    fun <T : DownloadableContent> writeJsons(destination: Path, items: List<T>) {
        if (items.isEmpty()) throw IllegalStateException("Lista obektów do zapisania jest pusta")
        checkDestination(destination)

        val type = object : TypeToken<T>() {}.type
        items.forEach { post ->
            FileWriter("$destination/${post.id}$EXT").use {
                gson.toJson(post, type, it)
            }
        }
    }

    private fun checkDestination(destination: Path) {
        if (!Files.exists(destination) || !Files.isDirectory(destination)) {
            throw FileNotFoundException("Wprowadzono błędną lokalizację")
        }
    }
}