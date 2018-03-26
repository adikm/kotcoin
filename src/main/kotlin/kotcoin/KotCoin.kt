package kotcoin

import io.javalin.Javalin

fun main(args: Array<String>) {
    val app = Javalin.start(7000)
    app.get("/") { ctx -> ctx.result("Hello Kotlin") }
}
