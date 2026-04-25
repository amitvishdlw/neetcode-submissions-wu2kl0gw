class Solution {
    fun maxProduct(nums: IntArray): Int {
        var maxProd = nums[0]
        for (i in 0 until nums.size) {
            var curProd = 1 
            for (j in i until nums.size) {
                curProd *= nums[j]
                maxProd = maxOf(maxProd, curProd)
            }
        }
        return maxProd
    }
}
