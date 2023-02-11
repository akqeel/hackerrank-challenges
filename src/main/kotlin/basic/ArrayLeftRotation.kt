import kotlin.collections.*
import kotlin.io.*

/**
 * Challenge: https://www.hackerrank.com/challenges/array-left-rotation
 *
 * Steps:
 * - Get the size of the input array, `length`
 * - Create a new null array of size `length`, `rotatedArray`
 * - For each element in the input array:
 *      - Subtract the number of positions to be shifted, `d`, from the current `index`
 *          - If the result is negative, then
 *              - Invert the sign of the result (multiply by -1): [neg * neg = pos]
 *                  - Count backwards. Subtract this result from `length` to get the shifted position
 *          - If the result is positive, then
 *              - This is the shifted position for this element.
 */
fun rotateLeft(d: Int, arr: Array<Int>): Array<Int> {
    val length = arr.size
    val rotatedArray = arrayOfNulls<Int>(length)
    arr.forEachIndexed { index, i ->
        var newIndex = index - d
        if (newIndex < 0) {
            newIndex = length - (newIndex*-1)
        }
        rotatedArray[newIndex] = i
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
    val shiftCount = 2
    val rotatedArray = rotateLeft(shiftCount, array)
    for (i in rotatedArray) {
         println(i)
    }
}
