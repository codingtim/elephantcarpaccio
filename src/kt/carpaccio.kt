package kt

fun main(args: Array<String>) {
    print()
}

fun print() {
    System.out.println(StringBuilder()
            .append("Amount: ").append(1).append("\n")
            .append("Price: ").append(100).append("\n")
            .append("State: ").append("-").append("\n")
            .append("Discount: ").append("-").append("\n")
            .append("TaxRate: ").append("-").append("\n")
            .append("Total: ").append(100).append("\n")
    )
}