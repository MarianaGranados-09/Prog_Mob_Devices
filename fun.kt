fun main() {
   println(greet("Ronin"))
}
fun greet(name: String): String{
    val namegreet = "Happy Birthday, $name!"
    return "$namegreet"
}
