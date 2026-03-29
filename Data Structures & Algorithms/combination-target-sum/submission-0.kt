class Solution {
    fun combinationSum(nums: IntArray, target: Int): List<List<Int>> {
        val ans = mutableSetOf<List<Int>>()
        fun dfs(sum: Int, curList: MutableList<Int>) {
            if (sum < 0) return
            if (sum == 0) {
                ans.add(curList.sorted())
                return
            }
            for (i in nums) {
                if (sum >= i) {
                    curList.add(i)
                    dfs(sum-i, curList)
                    curList.removeLast()
                }
            }
        }
        dfs(target, mutableListOf())
        return ans.toList()
    }
}
