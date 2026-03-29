class Solution {
    fun isAnagram(s: String, t: String): Boolean {
        val sa = s.toCharArray()
        val ta = t.toCharArray()
        sa.sort()
        ta.sort()
        return sa.contentEquals(ta)
    }
}
