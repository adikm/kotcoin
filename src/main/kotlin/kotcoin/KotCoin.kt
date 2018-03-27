package kotcoin

import io.javalin.Javalin

val kotcoin = Blockchain

fun main(args: Array<String>) {
    val app = Javalin.start(7000)
    app.get("/blocks") { ctx ->
        ctx.json(kotcoin.chain)
    }
    app.post("/blocks/mine") { ctx ->
        val minedBlock = kotcoin.mineBlock(ctx.body())
        ctx.json(minedBlock)
    }
}
