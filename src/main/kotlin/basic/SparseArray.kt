import java.io.*
import java.math.*
import java.security.*
import java.text.*
import java.util.*
import java.util.concurrent.*
import java.util.function.*
import java.util.regex.*
import java.util.stream.*
import kotlin.collections.*
import kotlin.comparisons.*
import kotlin.io.*
import kotlin.jvm.*
import kotlin.jvm.functions.*
import kotlin.jvm.internal.*
import kotlin.ranges.*
import kotlin.sequences.*
import kotlin.text.*

/**
 * Steps:
 * - Loop through the queries, `query`
 *      - Loop through the string list, `str`
 *          - Increment the count for index if `query` == `str`
 */
fun matchingStrings(stringList: Array<String>, queries: Array<String>): Array<Int> {
    val resultSize = queries.size
    val resultsArray = Array(resultSize) { 0 }
    for ((index, query) in queries.withIndex()) {
        for (str in stringList) {
            if (str == query) resultsArray[index]++
        }
    }
    return resultsArray
}

fun main(args: Array<String>) {
    val stringList = arrayOf("ab", "ab", "abc")
    val queries = arrayOf("ab", "abc", "bc")
    val result = matchingStrings(stringList, queries)
    for (count in result) {
        println(count)
    }
}
