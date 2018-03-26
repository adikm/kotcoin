package kotcoin

import org.apache.commons.codec.digest.DigestUtils
import java.util.*

class Block(val index: Int,
            val previousHash: String,
            val data: Any) {
    val hash = calculateHash()
    val timestamp: Long = Date().time

    private val transactions = mutableListOf<Transaction>()

    private fun calculateHash(): String {
        val input = (index.toString() + previousHash + timestamp + data).toByteArray()
        return DigestUtils.sha256Hex(input)
    }

    fun addTransaction(transaction: Transaction) {
        transactions.add(transaction)
    }

    fun getTransactions() = transactions

}
