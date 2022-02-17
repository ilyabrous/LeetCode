package PalindromeNumber

class Solution {
    fun isPalindrome(x: Int): Boolean {
        val temp = x.toString()
        val numbers = IntArray(temp.length)
        for (i in temp.indices) numbers[i] = temp[i] - '0'
        for (i in 0 until temp.length / 2) if (numbers[i] != numbers[numbers.size - 1 - i]) return false
        return true
    }
}

fun main() {
    val value = 123321

    println(Solution().isPalindrome(value))
}