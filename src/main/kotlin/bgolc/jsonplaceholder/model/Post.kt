package bgolc.jsonplaceholder.model

data class Post(
    val userId: Int,
    override val id: Int,
    val title: String,
    val body: String
) : DownloadableContent