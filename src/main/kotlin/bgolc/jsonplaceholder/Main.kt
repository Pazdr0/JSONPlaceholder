package bgolc.jsonplaceholder

fun main() {
    val pr = PostsReader()
    val posts = pr.readJsonFile("https://jsonplaceholder.typicode.com/posts")

    val pw = PostsWriter()
    pw.write(posts)
}