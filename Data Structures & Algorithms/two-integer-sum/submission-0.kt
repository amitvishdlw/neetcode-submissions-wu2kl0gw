class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val seen = mutableMapOf<Int, Int>()
        var ans = IntArray(2) { -1 }
        nums.forEachIndexed { index, num ->
            if (seen.contains(target - num)) {
                ans[0] = seen[target-num]!!
                ans[1] = index
                return ans
            }
            seen[num] = min(index, seen[num] ?: index)
        }
        return ans
    }
}
