import java.math.RoundingMode
import java.text.DecimalFormat

fun main() {
    getChange(1.12f, 0f)
}

fun getChange(total: Float, bought: Float) {
    val array: IntArray = intArrayOf(0, 0, 0, 0, 0, 0)
    var difference = total - bought

    if (difference >= 1)
        array[5] = difference.toString().split(".")[0].toInt()

    val df = DecimalFormat("#.##")
    df.roundingMode = RoundingMode.HALF_DOWN

    difference -= array[5]

    difference = df.format(difference).toFloat() * 1000

    array[4] = ((difference - (difference % 50)) / 500).toInt()

    if (array[4] > 0)
        difference -= (array[4] * 500)

    array[3] = ((difference - (difference % 25)) / 250).toInt()

    if (array[3] > 0)
        difference -= (array[3] * 250)

    array[2] = ((difference - (difference % 10)) / 100).toInt()

    if (array[2] > 0)
        difference -= (array[2] * 100)

    array[1] = ((difference - (difference % 5)) / 50).toInt()

    if (array[1] > 0)
        difference -= (array[1] * 50)

    array[0] = ((difference - (difference % 1)) / 10).toInt()

    if (array[0] > 0)
        difference -= (array[0] * 10)

    array.forEach {
        print("$it ")
    }
}