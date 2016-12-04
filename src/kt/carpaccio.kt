package kt

import j.LivingState
import j.Reader
import java.util.*

fun main(args: Array<String>) {
    val reader = Reader(Scanner(System.`in`))
    val price = reader.readDouble("price", 1, Int.MAX_VALUE)
    val amount = reader.readInt("amount", 1, Int.MAX_VALUE)
    val state = reader.readEnum("state")

    val order = Order(price, amount)
    val discount = calculateDiscount(order)
    val invoice = Invoice(order, state, discount)

    print(invoice)
}

fun print(invoice: Invoice) {
    System.out.println(StringBuilder()
            .append("Amount: ").append(invoice.order.amount).append("\n")
            .append("Price: ").append(invoice.order.price).append("\n")
            .append("State: ").append(invoice.state.name).append("\n")
            .append("Discount: ").append(invoice.totalDiscount).append("\n")
            .append("TaxRate: ").append(invoice.state.taxRate).append("%\n")
            .append("Total: ").append(invoice.total).append("\n")
            .append("TotalWithTax: ").append(invoice.totalWithTax).append("\n")
    )
}

fun calculateDiscount(order: Order): Discount {
    return when {
        order.total in 50000..Integer.MAX_VALUE -> PercentageDiscount(0.15)
        order.total in 10000..49999 -> PercentageDiscount(0.10)
        order.total in 7000..9999 -> PercentageDiscount(0.07)
        order.total in 5000..6999 -> PercentageDiscount(0.05)
        order.total in 1000..4999 -> PercentageDiscount(0.03)
        else -> NoDiscount()
    }
}

interface Discount {
    fun getDiscount(total: Double): Double
}

data class NoDiscount(val required: Unit = Unit) : Discount {
    override fun getDiscount(total: Double): Double = 0.0
}

data class PercentageDiscount(val percentage: Double) : Discount {
    override fun getDiscount(total: Double): Double = total * percentage
}

data class Invoice(val order: Order, val state: LivingState, val discount: Discount) {
    val totalDiscount = discount.getDiscount(order.total)
    val totalWithTax = (order.total - totalDiscount) * (1 + (state.taxRate / 100))
    val total = order.total - totalDiscount
}

data class Order(val price: Double, val amount: Int = 1) {
    val total = price * amount
}