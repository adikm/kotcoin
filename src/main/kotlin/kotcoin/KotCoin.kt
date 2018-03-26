package kotcoin

import io.javalin.Javalin
import java.util.*

val kotcoin = Blockchain

fun main(args: Array<String>) {
    val app = Javalin.start(7000)
    app.get("/chain") { ctx ->
        ctx.json(kotcoin.chain)
    }.post("/mine") { ctx ->
        val minedBlock = kotcoin.mineBlock(UUID.randomUUID())
        ctx.json(minedBlock)
    }

}
