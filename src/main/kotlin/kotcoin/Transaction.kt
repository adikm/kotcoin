package kotcoin

import java.util.*

data class Transaction(val from: String,
                       val to: String,
                       val timestamp: Long = Date().time)
