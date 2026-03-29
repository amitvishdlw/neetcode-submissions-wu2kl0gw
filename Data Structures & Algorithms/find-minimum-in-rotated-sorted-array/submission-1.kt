class Solution {
    fun findMin(nums: IntArray): Int {
        var l = 0; var r = nums.lastIndex
        while (l < r) {
            val mid = l + (r - l)/2
            val cur = nums[mid]
            if (cur < nums[r]) {
                r = mid
            } else {
                l = mid + 1
            }
        }
        return nums[l]
    }
}