package bgolc.jsonplaceholder.utils

import bgolc.jsonplaceholder.model.DownloadableContent
import com.google.gson.Gson
import java.io.FileNotFoundException
import java.lang.reflect.Type
import java.net.MalformedURLException
import java.net.URISyntaxException
import java.net.URL

class JsonReader {

    private val gson = Gson()

    fun <T : DownloadableContent> readJsonFile(stringUrl: String, type: Type): List<T> {
        if (!validateUrl(stringUrl)) return emptyList()
        val downloadedPosts = downloadPosts(stringUrl)

        return gson.fromJson(downloadedPosts, type)
    }

    private fun validateUrl(stringUrl: String): Boolean {
        return try {
            URL(stringUrl).toURI()
            true
        } catch (ex: MalformedURLException) {
            println("Nie poprawny adres URL: ${ex.message}")
            false
        } catch (ex: URISyntaxException) {
            println("Nie poprawny adres URL: ${ex.message}")
            false
        }
    }

    private fun downloadPosts(stringUrl: String): String {
        return try {
            URL(stringUrl).readText()
        } catch (ex: FileNotFoundException) {
            throw FileNotFoundException("Nie znaleziono pliku: ${ex.message}")
        }
    }
}