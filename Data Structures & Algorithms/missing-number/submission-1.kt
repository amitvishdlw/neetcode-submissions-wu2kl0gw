class Solution {
    fun missingNumber(nums: IntArray): Int {
        var fullXor = 0
        val n = nums.size
        for (i in (1..n)) {
            fullXor = fullXor xor i
        }
        for (i in nums) {
            fullXor = fullXor xor i
        }
        return fullXor
    }
}
