class Solution {
    fun combinationSum(nums: IntArray, target: Int): List<List<Int>> {
        val ans = mutableListOf<List<Int>>()
        fun dfs(sum: Int, i: Int, curList: MutableList<Int>) {
            if (sum < 0 || i == nums.size) return
            if (sum == 0) {
                ans.add(curList.toList())
                return
            }

            if (sum >= nums[i]) {
                curList.add(nums[i])
                dfs(sum - nums[i], i, curList)
                curList.removeLast()
            }
            dfs(sum, i+1, curList)
        }
        dfs(target, 0, mutableListOf())
        return ans
    }
}
