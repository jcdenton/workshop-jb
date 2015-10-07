package v_collections

fun Shop.getCustomersWhoOrderedProduct(product: Product): Set<Customer> {
    // Return the set of customers who ordered the specified product
    return customers.filter { it.orderedProducts.contains(product) }.toSet()
}

fun Customer.getMostExpensiveDeliveredProduct(): Product? {
    return orders
            .filter { it.isDelivered }
            .flatMap { it.products }
            .sortedByDescending { it.price }
            .firstOrNull()
}

fun Shop.getNumberOfTimesProductWasOrdered(product: Product): Int {
    // Return the number of times the given product was ordered.
    // Note: a customer may order the same product for several times.
    return customers.flatMap { it.orders }.flatMap { it.products }.count { it == product }
}
