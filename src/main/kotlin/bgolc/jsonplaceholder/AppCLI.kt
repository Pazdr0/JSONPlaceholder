package bgolc.jsonplaceholder

import bgolc.jsonplaceholder.model.Post
import bgolc.jsonplaceholder.utils.JsonReader
import bgolc.jsonplaceholder.utils.JsonWriter
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type
import java.nio.file.Paths

fun main() {
    val type: Type = object : TypeToken<List<Post>>() {}.type
    val jr = JsonReader()
    val posts = jr.readJsonFile<Post>("https://jsonplaceholder.typicode.com/posts", type)

    val jw = JsonWriter().writeJsons(
        Paths.get("/home/pazdr0/Documents/Dev/TestingCourse/Testing Java with JUnit 5/JSONPlaceholder/Jsons/"),
        posts
    )
}