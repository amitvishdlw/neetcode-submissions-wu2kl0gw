class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
        nums.sort()
        val dNums = nums.toList()
        val res = HashSet<List<Int>>()
        for (i in dNums.indices) {
            val cur = dNums[i]
            var l = i+1
            var r = dNums.lastIndex
            while (l < r) {
                val curSum = dNums[l] + dNums[r] + cur
                if (curSum <= 0) {
                    if (curSum == 0) {
                        res.add(listOf(cur, dNums[l], dNums[r]))
                    }
                    l++
                } else {
                    r--
                }
            }
        }
        return res.toList()
    }
}
