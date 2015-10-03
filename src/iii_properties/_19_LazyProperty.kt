package iii_properties

import util.TODO

class LazyProperty(val initializer: () -> Int) {
    private val lazyInit: Int? = null
        get() {
            if (field == null) field = initializer()
            return field
        }
    val lazy: Int
        get() = lazyInit!!
}

fun todoTask19() = TODO(
    """
        Task 19.
        Add a custom getter to make the 'lazy' val really lazy.
        It should be initialized by the invocation of 'initializer()'
        at the moment of the first access.
        You can add as many additional properties as you need.
        Do not use delegates ;).
    """,
    references = { LazyProperty({ 42 }).lazy }
)
