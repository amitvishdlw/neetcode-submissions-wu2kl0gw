class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        var ans = 0
        val subSet = HashSet<Char>()
        
        var l = 0

        s.forEach { c ->
            if (subSet.contains(c)) {
                ans = max(ans, subSet.size)

                while(subSet.contains(c)) {
                    subSet.remove(s[l])
                    l++
                }

                subSet.add(c)
            } else {
                subSet.add(c)
            }
        }
        ans = max(ans, subSet.size)
        return ans
    }
}
