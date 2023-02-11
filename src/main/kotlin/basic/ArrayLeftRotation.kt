import kotlin.collections.*
import kotlin.io.*

/**
 * Challenge: https://www.hackerrank.com/challenges/array-left-rotation
 *
 * Steps:
 * - Get the size of the input array, `length`
 * - Create a new null array of size `length`, `rotatedArray`
 * - Fill the first `d` elements of the new array with the last `d` elements of the input array.
 * - Fill the last `d - length` elements of the new array with the first `d - length` elements of the input array.
 */
fun rotateLeft(d: Int, arr: Array<Int>): Array<Int> {
    val length = arr.size
    val rotatedArray = arrayOfNulls<Int>(length)
    for (i in d until length) {
        rotatedArray[i - d] = arr[i]
    }
    for (i in 0 until d) {
        rotatedArray[length - d + i] = arr[i]
    }
    return rotatedArray.filterNotNull().toTypedArray()
}

/**
 * Shifting right instead of left. This is simpler compared to shifting left.
 * Steps:
 * - Get the `modIndex`, the current index modulus the shift count
 *      - This is the shifted index.
 */
fun rotateRight(d: Int, arr: Array<Int>): Array<Int> {
    val length = arr.size
    val rotatedArray = arrayOfNulls<Int>(length)
    arr.forEachIndexed { index, i ->
        val newIndex = index + d
        val modIndex = newIndex % (length)
        rotatedArray[modIndex] = i
    }
    return rotatedArray.filterNotNull().toTypedArray()
}

fun main(args: Array<String>) {
    val array = arrayOf(1, 2, 3, 4, 5)
    val shiftCount = 4
    val rotatedArray = rotateLeft(shiftCount, array)
    for (i in rotatedArray) {
         println(i)
    }
}
