package kotcoin

object Blockchain {
    val chain = mutableListOf<Block>()
    val latestBlock: Block
        get() = chain.last()

    init {
        chain.add(Block(0, "0", "Genesis block", 0))
    }

    fun mineBlock(data: Any): Block {
        val proofOfWork = generateProofOfWork(latestBlock.proofOfWork)
        val block = Block(chain.size, latestBlock.hash, data, proofOfWork)

        addNewBlock(block)

        return latestBlock
    }

    private fun addNewBlock(block: Block) {
        if (isNewBlockValid(block)) chain.add(block)
    }

    private fun generateProofOfWork(previousPow: Int, difficulty: Int = 1): Int {
        var proof = previousPow + 1
        val nonce = 19 * difficulty
        while ((proof + previousPow) % nonce != 0) {
            proof += 1
        }
        return proof
    }

    private fun isNewBlockValid(newBlock: Block): Boolean =
            ((newBlock.index == latestBlock.index + 1) || (newBlock.previousHash == latestBlock.hash))

}
