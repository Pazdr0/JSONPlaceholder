package bgolc.jsonplaceholder.test

import bgolc.jsonplaceholder.model.Post
import bgolc.jsonplaceholder.utils.JsonWriter
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.io.FileNotFoundException
import java.nio.file.Files
import java.nio.file.Paths

class JsonWriterTest {

    private lateinit var writer: JsonWriter

    @BeforeEach
    fun setUp() {
        writer = JsonWriter()
    }

    @Test
    fun writeJsonsTest() {
        val destinationIncorrect = Paths.get("file.txt")
        val destinationIncorrect2 = Paths.get("files")
        val destinationCorrect = Paths.get("Files")
        Files.createTempDirectory(destinationCorrect.toString())

        val post = Post(1, 1, "title", "body")
        assertThrows<FileNotFoundException> { writer.writeJsons(destinationIncorrect, listOf(post)) }
        assertThrows<FileNotFoundException> { writer.writeJsons(destinationIncorrect2, listOf(post)) }
        assertThrows<FileNotFoundException> { writer.writeJsons(destinationCorrect, listOf(post)) }
        assertThrows<IllegalStateException> { writer.writeJsons(destinationCorrect, emptyList()) }
    }
}