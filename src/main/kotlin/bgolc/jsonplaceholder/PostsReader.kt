package bgolc.jsonplaceholder

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import java.io.FileNotFoundException
import java.lang.reflect.Type
import java.net.MalformedURLException
import java.net.URISyntaxException
import java.net.URL

class PostsReader {

    private val gson = Gson()

    fun readJsonFile(stringUrl: String): List<Post> {
        if (!validateUrl(stringUrl)) return emptyList()

        val postType: Type = object : TypeToken<List<Post>>() {}.type
        val downloadedPosts = downloadPosts(stringUrl)

        return gson.fromJson(downloadedPosts, postType)
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