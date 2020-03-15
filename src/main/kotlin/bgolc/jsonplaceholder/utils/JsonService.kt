package bgolc.jsonplaceholder.utils

import bgolc.jsonplaceholder.model.DownloadableContent
import java.lang.reflect.Type
import java.nio.file.Path
import java.nio.file.Paths

class JsonService : Reader, Writer {

    private val reader = JsonReader()
    private val writer = JsonWriter()
    private lateinit var jsonList: List<DownloadableContent>
    private lateinit var destination: Path

    override fun readFile(stringUrl: String, type: Type) {
        jsonList = reader.readJsonFile(stringUrl, type)
    }

    override fun getDestiantion(path: String) {
        destination = Paths.get(path)
    }

    override fun saveFiles() {
        if (this::jsonList.isInitialized && this::destination.isInitialized) {
            writer.writeJsons(destination, jsonList)
        }
    }
}

interface Reader {
    fun readFile(stringUrl: String, type: Type)
}

interface Writer {
    fun getDestiantion(path: String)
    fun saveFiles()
}
