import java.util.Scanner

import j.{LivingState, Reader}

object carpaccio extends App {
  val reader = new Reader(new Scanner(System.in))

  val price = reader.readDouble("price", 1, Integer.MAX_VALUE)
  val amount = reader.readInt("amount", 1, Integer.MAX_VALUE)
  val state = reader.readEnum("state")

  val orderWithTax = for {
    order <- createOrder(price, amount)
    orderWithTax <- calculateTax(order, state)
  } yield orderWithTax

  if(orderWithTax.nonEmpty) {
    print(orderWithTax.get)
  }


  def print(order: OrderWithTax): Unit = {
    System.out.println(new StringBuilder()
      .append("Amount: ").append(order.amount).append("\n")
      .append("Price: ").append(order.price).append("\n")
      .append("State: ").append(order.state.name()).append("\n")
      .append("Discount: ").append("-").append("\n")
      .append("TaxRate: ").append(order.state.getTaxRate).append("%\n")
      .append("Total: ").append(order.total).append("\n")
      .append("TotalWithTax: ").append(order.totalWithTax).append("\n")
    )
  }

  def createOrder(price: Double, amount: Int): Option[Order] = Some(Order(price, amount))
  def calculateTax(order: Order, state: LivingState): Option[OrderWithTax] = Some(OrderWithTax(price, amount, state))
}

trait OrderTrait {
  def price: Double
  def amount: Int
}

case class Order(price: Double, amount: Int = 1) extends OrderTrait {
  val total = price * amount
}

case class OrderWithTax(price: Double, amount: Int = 1, state: LivingState) extends OrderTrait {
  val total = price * amount
  val totalWithTax = price * amount * (1 + (state.getTaxRate / 100))
}