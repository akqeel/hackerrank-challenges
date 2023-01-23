/**
 * Challenge: https://www.hackerrank.com/challenges/2d-array/problem
 *
 * Steps:
 * - Set `sum` as the lowest integer value.
 * - Loop through the 2D array horizontally
 *      - Loop through the 2D array vertically.
 *          - Calculate the sum for line 1
 *          - Calculate the sum for line 2
 *          - Calculate the sum for line 3
 *          - Calculate the total sum for the 3 lines, `tempSum`
 *          - Update `sum` if `tempSum` is greater than `sum`
 * - Return `sum`
 */

package basic

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

fun hourglassSum(arr: Array<Array<Int>>): Int {
    var sum = Int.MIN_VALUE
    val n = arr.size
    val hourGlassWidth = 3
    val hourGlassHeight = 3
    for (arrIndexW in 0 .. n - hourGlassWidth) {
        for (arrIndexH in 0 .. n - hourGlassHeight) {
            val arrayLine1 = arr[arrIndexH]
            val arrayLine2 = arr[arrIndexH + 1]
            val arrayLine3 = arr[arrIndexH + 2]
            val sumOfLine1 = arrayLine1[arrIndexW] + arrayLine1[arrIndexW + 1] + arrayLine1[arrIndexW + 2]
            val sumOfLine2 = arrayLine2[arrIndexW + 1]
            val sumOfLine3 = arrayLine3[arrIndexW] + arrayLine3[arrIndexW + 1] + arrayLine3[arrIndexW + 2]
            val sumTemp = (sumOfLine1 + sumOfLine2 + sumOfLine3)
            sum = if (sumTemp > sum) sumTemp else sum
        }
    }
    return sum
}

fun main(args: Array<String>) {

    val arr = Array<Array<Int>>(6, { Array<Int>(6, { 0 }) })

    for (i in 0 until 6) {
        arr[i] = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()
    }

    val result = hourglassSum(arr)

    println(result)
}
