class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val arr = mutableListOf<Int>()

        for (i in 0 until nums.size - 1) {
            for (j in i + 1 until nums.size) {
                if (nums[i] + nums[j] == target) {
                    arr.add(i)
                    arr.add(j)
                    return arr.toIntArray()
                }
            }
        }

        return arr.toIntArray()
    }
}