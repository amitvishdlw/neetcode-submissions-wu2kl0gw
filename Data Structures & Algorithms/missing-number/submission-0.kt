class Solution {
    fun missingNumber(nums: IntArray): Int {
        val n = nums.size
        val seen = HashSet<Int>()
        for (i in nums) {
            seen.add(i)
        }
        var mex = 0
        while (mex <= n) {
            if (seen.contains(mex)) {
                mex++
            } else {
                break
            }
        }
        return mex
    }
}
