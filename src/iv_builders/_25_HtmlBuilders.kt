package iv_builders

import iv_builders.data.getProducts
import iv_builders.htmlLibrary.*
import util.TODO

fun getTitleColor() = "#b9c9fe"
fun getCellColor(index: Int, row: Int) = if ((index + row) %2 == 0) "#dce4ff" else "#eff2ff"

fun todoTask25() = TODO(
    """
        Task 25.
        1) Fill the table with the proper values from products.
        2) Color the table like a chess board (using getTitleColor() and getCellColor() functions above).
        Pass a color as an argument to functions 'tr', 'td'.
        You can run the 'Html Demo' configuration in IntelliJ to see the rendered table.
    """
)

fun renderProductTable(): String {
    return html {
        table {
            tr {
                td(getTitleColor()) {
                    text("Product")
                }
                td(getTitleColor()) {
                    text("Price")
                }
                td(getTitleColor()) {
                    text("Popularity")
                }
            }
            for ((index, product) in getProducts().withIndex()) {
                tr {
                    td(getCellColor(0, index)) {
                        text(product.description)
                    }
                    td(getCellColor(1, index)) {
                        text(product.price)
                    }
                    td(getCellColor(2, index)) {
                        text(product.popularity)
                    }
                }
            }
        }
    }.toString()
}
