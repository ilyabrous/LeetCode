package ValidParentheses

class Solution {
    val stack = ArrayDeque<Char>()

    fun isValid(s: String): Boolean {
        val arr = s.toCharArray()
        for (char in arr) {
            if (stack.isNotEmpty()) {
                if (isCorrect(stack.first(), char)) {
                    stack.removeFirst()
                    continue
                }
            }
            stack.addFirst(char)
        }
        return stack.size == 0
    }

    private fun isCorrect(charOne: Char, charSecond: Char): Boolean = when (charOne) {
            '{' -> charSecond == '}'
            '(' -> charSecond == ')'
            '[' -> charSecond == ']'
            else -> false
    }
}

fun main() {
    val arr = "()[][][][][[{}]]"

    println(Solution().isValid(arr))
}