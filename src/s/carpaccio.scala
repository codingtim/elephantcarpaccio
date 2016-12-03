import java.util.Scanner

import j.Reader

object carpaccio extends App {
  val reader = new Reader(new Scanner(System.in))

  val price = reader.readDouble("price", 1, Integer.MAX_VALUE)
  val order = Order(price)

  print(order)


  def print(order: Order): Unit = {
    System.out.println(new StringBuilder()
      .append("Amount: ").append(1).append("\n")
      .append("Price: ").append(order.price).append("\n")
      .append("State: ").append("-").append("\n")
      .append("Discount: ").append("-").append("\n")
      .append("TaxRate: ").append("-").append("%\n")
      .append("Total: ").append("-").append("\n")
      .append("TotalWithTax: ").append("100").append("\n")
    )
  }
}

case class Order(price: Double, amount: Int = 1) {

}