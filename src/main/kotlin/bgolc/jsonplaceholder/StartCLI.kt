package bgolc.jsonplaceholder

import bgolc.jsonplaceholder.model.Post
import bgolc.jsonplaceholder.utils.JsonReader
import bgolc.jsonplaceholder.utils.JsonWriter
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type
import java.nio.file.Files
import java.nio.file.Paths

fun main() {
    val jr = JsonReader()
    val type: Type = object : TypeToken<List<Post>>() {}.type
    val posts = jr.readJsonFromUrl<Post>("https://jsonplaceholder.typicode.com/posts", type)

    val projectPath = Paths.get("Jsons")
    if (!Files.exists(projectPath))
        Files.createDirectory(projectPath)
    JsonWriter().writeJsons(projectPath, posts)
}
