package v_collections

fun example4() {
    val max = listOf(1, 42, 4).max()
    val longestString = listOf("a", "b").maxBy { it.length() }
}

fun Shop.getCustomerWithMaximumNumberOfOrders(): Customer? {
    return customers.sortedByDescending { it.orders.size() }.firstOrNull()
}

fun Customer.getMostExpensiveOrderedProduct(): Product? {
    return orderedProducts.sortedByDescending { it.price }.firstOrNull()
}
