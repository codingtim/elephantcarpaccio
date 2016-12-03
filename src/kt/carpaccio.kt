package kt

import j.Reader
import java.util.*

fun main(args: Array<String>) {
    val reader = Reader(Scanner(System.`in`))
    val price = reader.readDouble("price", 1, Int.MAX_VALUE)
    val amount = reader.readInt("amount", 1, Int.MAX_VALUE)
    print(Order(price, amount))
}

fun print(order: Order) {
    System.out.println(StringBuilder()
            .append("Amount: ").append(order.amount).append("\n")
            .append("Price: ").append(order.price).append("\n")
            .append("State: ").append("-").append("\n")
            .append("Discount: ").append("-").append("\n")
            .append("TaxRate: ").append("-").append("\n")
            .append("Total: ").append(order.total).append("\n")
    )
}

data class Order(val price: Double, val amount: Int = 1) {
    val total = price * amount
}