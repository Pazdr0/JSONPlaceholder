package bgolc.jsonplaceholder.model

class Comment(
    val postId: Int,
    override val id: Int,
    val name: String,
    val email: String,
    val body: String
) : DownloadableContent