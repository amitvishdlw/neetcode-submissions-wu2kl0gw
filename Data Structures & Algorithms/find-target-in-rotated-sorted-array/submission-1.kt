class Solution {
    fun search(nums: IntArray, target: Int): Int {
        var l = 0
        var r = nums.lastIndex

        while (l < r) {
            val mid = l + (r - l) / 2

            if (nums[mid] < nums[r]) { // sorted
                if (nums[mid] == target) return mid
                else if (target > nums[mid] && target <= nums[r]) {
                    l = mid + 1 
                } else {
                    r = mid
                }
            } else { // unsorted
                if (nums[mid] == target) return mid
                else if (target < nums[mid] && target >= nums[l]) {
                    r = mid - 1
                } else {
                    l = mid + 1
                }
            }
        }
        return if (nums[l] == target) l else -1
    }
}