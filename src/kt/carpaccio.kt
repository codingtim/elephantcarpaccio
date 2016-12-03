package kt

import j.Reader
import java.util.*

fun main(args: Array<String>) {
    val reader = Reader(Scanner(System.`in`))
    val price = reader.readDouble("price", 1, Int.MAX_VALUE)
    print(price)
}

fun print(price: Double) {
    System.out.println(StringBuilder()
            .append("Amount: ").append(1).append("\n")
            .append("Price: ").append(price).append("\n")
            .append("State: ").append("-").append("\n")
            .append("Discount: ").append("-").append("\n")
            .append("TaxRate: ").append("-").append("\n")
            .append("Total: ").append(100).append("\n")
    )
}