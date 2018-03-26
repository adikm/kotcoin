package kotcoin

object Blockchain {
    val chain = mutableListOf(createGenesisBlock())

    fun mineBlock(data: Any): Block {
        val proofOfWork = generateProofOfWork(getLatestBlock().proofOfWork)
        val block = Block(chain.size, getLatestBlock().hash, data, proofOfWork)

        addNewBlock(block)

        return getLatestBlock()
    }

    fun addNewBlock(block: Block) {
        if (isNewBlockValid(block)) chain.add(block)
    }

    fun getLatestBlock(): Block {
        return chain.last()
    }

    private fun generateProofOfWork(previousPow: Int, difficulty: Int = 1): Int {
        var proof = previousPow + 1
        val nonce = 19 * difficulty
        while ((proof + previousPow) % nonce != 0) {
            proof += 1
        }
        return proof
    }

    private fun createGenesisBlock(): Block {
        return Block(0, "0", "Genesis block", 0)
    }

    private fun isNewBlockValid(newBlock: Block): Boolean =
            ((newBlock.index == getLatestBlock().index + 1) || (newBlock.previousHash == getLatestBlock().hash))

}