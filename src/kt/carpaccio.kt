package kt

import j.LivingState
import j.Reader
import java.util.*

fun main(args: Array<String>) {
    val reader = Reader(Scanner(System.`in`))
    val price = reader.readDouble("price", 1, Int.MAX_VALUE)
    val amount = reader.readInt("amount", 1, Int.MAX_VALUE)
    val state = reader.readEnum("state")
    print(Invoice(Order(price, amount), state))
}

fun print(invoice: Invoice) {
    System.out.println(StringBuilder()
            .append("Amount: ").append(invoice.order.amount).append("\n")
            .append("Price: ").append(invoice.order.price).append("\n")
            .append("State: ").append(invoice.state.name).append("\n")
            .append("Discount: ").append("-").append("\n")
            .append("TaxRate: ").append(invoice.state.taxRate).append("%\n")
            .append("Total: ").append(invoice.order.total).append("\n")
            .append("TotalWithTax: ").append(invoice.totalWithTax).append("\n")
    )
}

data class Invoice(val order: Order, val state: LivingState) {
    val totalWithTax = order.total * (1 + (state.taxRate / 100))
}

data class Order(val price: Double, val amount: Int = 1) {
    val total = price * amount
}