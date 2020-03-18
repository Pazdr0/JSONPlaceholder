package bgolc.jsonplaceholder.test

import bgolc.jsonplaceholder.model.Post
import bgolc.jsonplaceholder.utils.JsonReader
import com.google.gson.reflect.TypeToken
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.io.TempDir
import java.io.File
import java.io.FileNotFoundException
import java.net.MalformedURLException
import java.net.URISyntaxException
import java.nio.file.Files

class JsonReaderTest {

    private lateinit var reader: JsonReader

    @BeforeEach
    fun setUp() {
        reader = JsonReader()
    }

    @Test
    fun readJsonStringTest(@TempDir tempDir: File) {
        val file = File(tempDir, "test.json")
        Files.writeString(file.toPath(), "test")

        assertEquals("test", reader.downloadContent(file.toURI().toString()))
        assertAll("Downloading exceptions",
            {
                assertThrows<URISyntaxException> {
                    reader.downloadContent("https:/ /jsonplaceholder.typicode.com/ posts")
                }
            }, {
                assertThrows<MalformedURLException> {
                    reader.downloadContent("htps://jsonplaceholder.typicode.com/posts")
                }
            }, {
                assertThrows<FileNotFoundException> {
                    reader.downloadContent("https://jsonplaceholder.typicode.com/post")
                }
            }
        )
    }

    @Test
    fun readJsonStringTest() {
        val post1 = Post(1, 1, "title", "body")
        val post2 = Post(2, 2, "title", "body")

        val jsonTestString = StringBuilder()
            .append("{ \"userId\" : ${post1.userId},")
            .append("\"id\" : ${post1.id},")
            .append("\"title\" : ${post1.title},")
            .append("\"body\" : ${post1.body} }")
        val jsonTestString2 = StringBuilder()
            .append("{ \"userId\" : ${post2.userId},")
            .append("\"id\" : ${post2.id},")
            .append("\"title\" : ${post2.title},")
            .append("\"body\" : ${post2.body} }")
        val listType = object : TypeToken<List<Post>>() {}.type

        val expectedList = listOf(post1, post2)
        assertEquals(expectedList, reader.readJsonString<Post>("[ $jsonTestString, $jsonTestString2 ]", listType))
        assertEquals(1, reader.readJsonString<Post>("[ $jsonTestString ]", listType).size)
        assertEquals(2, reader.readJsonString<Post>("[ $jsonTestString, $jsonTestString2 ]", listType).size)
    }

}