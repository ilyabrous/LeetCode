package ValidParentheses

class Solution {
    val stack = ArrayDeque<Char>()

    fun isValid(s: String): Boolean {
        val arr = s.toCharArray()
        for (i in arr.indices) {
            if (stack.isNotEmpty()) {
                if (isCorrect(stack.first(), arr[i])) {
                    stack.removeFirst()
                    continue
                }
            }
            stack.addFirst(arr[i])
        }
        return stack.size == 0
    }

    private fun isCorrect(charOne: Char, charSecond: Char): Boolean {
        return when (charOne) {
            '{' -> charSecond == '}'
            '(' -> charSecond == ')'
            '[' -> charSecond == ']'
            else -> false
        }

    }
}

fun main() {
    val arr = "()[][][][](())))[[{}]]"


    println(Solution().isValid(arr))
}