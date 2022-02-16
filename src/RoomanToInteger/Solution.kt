package RoomanToInteger

class Solution {

    private val hashMapRomance = hashMapOf(
        'I' to 1,
        'V' to 5,
        'X' to 10,
        'L' to 50,
        'C' to 100,
        'D' to 500,
        'M' to 1000
    )

    fun romanToInt(s: String): Int {
        var valueOfInt = 0
        val setOfSkip = mutableSetOf<Int>()

        hashMapRomance.forEach { (char, value) ->
            transactions@ for (i in s.indices) {
                if (setOfSkip.contains(i)) continue
                var subtractionValue = 0
                if (s[i] == char) {
                    if (i < s.length - 1) {
                        when (s[i]) {
                            'X' -> if (s[i + 1] == 'L' || s[i + 1] == 'C') continue@transactions
                            'C' -> if (s[i + 1] == 'D' || s[i + 1] == 'M') continue@transactions
                            'I' -> if (s[i + 1] == 'V' || s[i + 1] == 'X') continue@transactions
                        }
                    }
                    if (i > 0) {
                        when (s[i]) {
                            'V', 'X' -> if (s[i - 1] == 'I') subtractionValue = 1
                            'L', 'C' -> if (s[i - 1] == 'X') subtractionValue = 10
                            'D', 'M' -> if (s[i - 1] == 'C') subtractionValue = 100
                        }
                    }
                    setOfSkip.add(i)
                    if(subtractionValue > 0) setOfSkip.add(i)
                    valueOfInt += value - subtractionValue
                }
            }
        }
        return valueOfInt
    }

    fun romanToInt2(s: String): Int {
        var biggestChar = 0
        return s.foldRight(0) { c, acc ->
            val v = fromRomanToInteger(c)
            biggestChar = Math.max(v, biggestChar)
            acc + if(v >= biggestChar) v else -v
        }
    }

    fun fromRomanToInteger(char: Char) = when(char) {
        'I' -> 1
        'V' -> 5
        'X' -> 10
        'L' -> 50
        'C' -> 100
        'D' -> 500
        'M' -> 1000
        else -> -1
    }
}

fun main() {
    val romanceValue = "MMMDCCXXIV"

    val result = Solution().romanToInt(romanceValue)

    println(result)
}