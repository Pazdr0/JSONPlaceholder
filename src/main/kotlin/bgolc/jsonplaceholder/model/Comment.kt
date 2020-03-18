package bgolc.jsonplaceholder.model

data class Comment(
    val postId: Int,
    override val id: Int,
    val name: String,
    val email: String,
    val body: String
) : DownloadableContent