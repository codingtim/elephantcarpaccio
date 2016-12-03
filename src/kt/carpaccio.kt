package kt

import j.LivingState
import j.Reader
import java.util.*

fun main(args: Array<String>) {
    val reader = Reader(Scanner(System.`in`))
    val price = reader.readDouble("price", 1, Int.MAX_VALUE)
    val amount = reader.readInt("amount", 1, Int.MAX_VALUE)
    val state = reader.readEnum("state")
    print(Order(price, amount), state)
}

fun print(order: Order, state: LivingState) {
    System.out.println(StringBuilder()
            .append("Amount: ").append(order.amount).append("\n")
            .append("Price: ").append(order.price).append("\n")
            .append("State: ").append(state.name).append("\n")
            .append("Discount: ").append("-").append("\n")
            .append("TaxRate: ").append(state.taxRate).append("\n")
            .append("Total: ").append(order.total).append("\n")
    )
}

data class Order(val price: Double, val amount: Int = 1) {
    val total = price * amount
}