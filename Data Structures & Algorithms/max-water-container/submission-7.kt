class Solution {
    fun maxArea(h: IntArray): Int {
        var i = 0
        var j = h.lastIndex
        var ans = 0
        while (i < j) {
            val area = min(h[i],h[j]) * (j-i)
            ans = max(ans, area)
            if (h[i] <= h[j]) {
                i++
            } else {
                j--
            }
        }
        return ans
    }
}

