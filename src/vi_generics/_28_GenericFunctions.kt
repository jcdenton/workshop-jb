package vi_generics.generics

import java.util.ArrayList
import java.util.HashSet
import util.TODO

fun task28() = TODO(
    """
        Task28.
        Add a 'partitionTo' function that splits a collection into two collections according to a predicate.
        Uncomment the commented invocations of 'partitionTo' below and make them compile.

        There is a 'partition()' function in the standard library that always returns two newly created lists.
        You should write a function that splits the collection into two collections given as arguments.
        The signature of the 'toCollection()' function from the standard library may help you.
    """,
        references = { l: List<Int> ->
            l.partition { it > 0 }
            l.toCollection(HashSet<Int>())
        }
)

fun <E, C : MutableCollection<E>> Collection<E>.partitionTo(matched: C, notMatched: C,
                                                            predicate: (E) -> Boolean): Pair<C, C> {
    forEach {
        if (predicate(it)) matched += it
        else notMatched += it
    }
    return Pair(matched, notMatched)
}

fun List<String>.partitionWordsAndLines(): Pair<List<String>, List<String>> {
//    task28()
    return partitionTo(ArrayList<String>(), ArrayList()) { s -> !s.contains(" ") }
}

fun Set<Char>.partitionLettersAndOtherSymbols(): Pair<Set<Char>, Set<Char>> {
//    task28()
    return partitionTo(HashSet<Char>(), HashSet()) { c -> c in 'a'..'z' || c in 'A'..'Z'}
}
