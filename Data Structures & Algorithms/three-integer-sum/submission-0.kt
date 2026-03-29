class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
        return buildSet<List<Int>> {
            val seen = mutableSetOf<Int>()
            nums.forEachIndexed { idx, num ->
                val target = num
                for (i in idx+1..<nums.size) {
                    val cur = nums[i]
                    if (seen.contains(-target-cur)) {
                        val triplets = mutableListOf<Int>(target, -target-cur, cur)
                        triplets.sort()
                        add(triplets)
                    }
                    seen.add(cur)
                }
                seen.clear()
            }
        }.toList()
    }
}
