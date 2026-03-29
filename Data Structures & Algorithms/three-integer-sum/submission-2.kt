class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {

        nums.sort()
        val res = mutableListOf<List<Int>>()

        for (i in nums.indices) {

            if (nums[i] > 0) break

            if (i > 0 && nums[i] == nums[i - 1]) continue

            var l = i + 1
            var r = nums.lastIndex

            while (l < r) {

                val sum = nums[i] + nums[l] + nums[r]

                when {
                    sum < 0 -> l++
                    sum > 0 -> r--
                    else -> {
                        res.add(listOf(nums[i], nums[l], nums[r]))

                        l++
                        r--

                        while (l < r && nums[l] == nums[l - 1]) l++
                        while (l < r && nums[r] == nums[r + 1]) r--
                    }
                }
            }
        }

        return res
    }
}