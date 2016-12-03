package kt

import j.LivingState
import j.Reader
import java.util.*

fun main(args: Array<String>) {
    val reader = Reader(Scanner(System.`in`))
    val price = reader.readDouble("price", 1, Int.MAX_VALUE)
    val amount = reader.readInt("amount", 1, Int.MAX_VALUE)
    val state = reader.readEnum("state")
    print(OrderWithTax(Order(price, amount), state))
}

fun print(orderWithTax: OrderWithTax) {
    System.out.println(StringBuilder()
            .append("Amount: ").append(orderWithTax.order.amount).append("\n")
            .append("Price: ").append(orderWithTax.order.price).append("\n")
            .append("State: ").append(orderWithTax.state.name).append("\n")
            .append("Discount: ").append("-").append("\n")
            .append("TaxRate: ").append(orderWithTax.state.taxRate).append("\n")
            .append("Total: ").append(orderWithTax.order.total).append("\n")
            .append("TotalWithTax: ").append(orderWithTax.totalWithTax).append("\n")
    )
}

data class OrderWithTax(val order: Order, val state: LivingState) {
    val totalWithTax = order.total * (1 + (state.taxRate / 100))
}

data class Order(val price: Double, val amount: Int = 1) {
    val total = price * amount
}