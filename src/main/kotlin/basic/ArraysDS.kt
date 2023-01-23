/**
 * Challenge: https://www.hackerrank.com/challenges/arrays-ds/problem
 *
 * Steps:
 * - Get the size of the input array, `n`
 * - Create a new integer array with size `n`
 *       - Set the value at each index starting from the end of the input array `a`
 * - Return the newly created integer array
 */

import kotlin.collections.*
import kotlin.io.*
import kotlin.text.*

fun main(args: Array<String>) {
    val arrCount = readLine()!!.trim().toInt()

    val arr = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

    val res = reverseArray(arr)

    println(res.joinToString(" "))
}

fun reverseArray(a: Array<Int>): Array<Int> {
    val n = a.size
    return Array(n) { i ->
        a[n - i - 1]
    }
}
