package bgolc.jsonplaceholder.utils

import bgolc.jsonplaceholder.model.DownloadableContent
import com.google.gson.Gson
import java.lang.reflect.Type
import java.net.URL

internal class JsonReader {

    private val gson = Gson()

    fun <T : DownloadableContent> readJsonFromUrl(stringUrl: String, listType: Type): List<T> {
        val jsonString = downloadContent(stringUrl)
        return gson.fromJson(jsonString, listType)
    }

    fun <T : DownloadableContent> readJsonString(jsonString: String, listType: Type): List<T> {
        return gson.fromJson(jsonString, listType)
    }

    fun downloadContent(stringUrl: String): String {
        validateUrl(stringUrl)
        return URL(stringUrl).readText()
    }

    private fun validateUrl(stringUrl: String) {
        URL(stringUrl).toURI()
    }
}