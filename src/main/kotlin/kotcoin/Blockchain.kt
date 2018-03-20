package kotcoin

object Blockchain {
    val chain: MutableList<Block> = mutableListOf(createGenesisBlock())

    fun addNewBlock(data: Any) {
        val block = Block(chain.size + 1, getLastBlock().hash, data)
        chain.add(block)
    }

    fun getLastBlock(): Block {
        return chain.last()
    }

    private fun createGenesisBlock(): Block {
        return Block(0, "0", "Genesis block")
    }
}

fun main(args: Array<String>) {
    val kotcoin = Blockchain

    for (i in 1..15) {
        kotcoin.addNewBlock("Block $i")
    }
    
    for (block in kotcoin.chain) {
        println("""Data: ${block.data}
            |Previous hash: ${block.previousHash}
            |Current hash: ${block.hash}
        |""".trimMargin())
    }
}
