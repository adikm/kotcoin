package kotcoin

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class BlockchainTest {

    @Test
    fun `Get latest block, chain just initialized, returns genesis block`() {
        val chain = Blockchain
        val latestBlock = chain.latestBlock

        assertEquals(0, latestBlock.index)
        assertEquals("Genesis block", latestBlock.data)
        assertEquals(0, latestBlock.proofOfWork)
    }

    @Test
    fun `Mine block, block added to the chain`() {
        val chain = Blockchain

        val minedBlock = chain.mineBlock("data")

        assertEquals(minedBlock, chain.latestBlock)
    }

    @Test
    fun `Mine block, assert created values`() {
        val chain = Blockchain
        val genesisBlock = chain.latestBlock

        val minedBlock = chain.mineBlock("data")

        val expectedProofOfWork = 19

        assertEquals(genesisBlock.hash, minedBlock.previousHash)
        assertEquals("data", minedBlock.data)
        assertEquals(genesisBlock.index + 1, minedBlock.index)
        assertEquals(expectedProofOfWork, minedBlock.proofOfWork)
        assertNotNull(minedBlock.hash)
        assertNotNull(minedBlock.timestamp)
    }

}
