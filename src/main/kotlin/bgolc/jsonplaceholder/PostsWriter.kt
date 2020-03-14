package bgolc.jsonplaceholder

import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import java.io.FileWriter
import java.nio.file.Path
import java.nio.file.Paths


class PostsWriter {

    private val gson = GsonBuilder()
        .setPrettyPrinting()
        .create()

    private companion object {
        const val EXT = ".json"
    }
    private val path: Path = Paths.get("/home/pazdr0/Documents/Dev/TestingCourse/Testing Java with JUnit 5/JSONPlaceholder/Jsons")

    fun write(posts: List<Post>) {
        val postType = object : TypeToken<Post>() {}.type
        posts.forEach { post ->
            FileWriter("$path/${post.id}$EXT").use {
                gson.toJson(post, postType, it)
            }
        }
    }
}