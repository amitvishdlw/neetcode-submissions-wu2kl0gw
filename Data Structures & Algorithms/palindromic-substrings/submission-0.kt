class Solution {
    fun countSubstrings(s: String): Int {
        val n = s.length
        var cnt = 0
        for (i in 0..<n) {
            for (j in i+1..n) {
                val s1 = s.substring(i,j)
                val s2 = s1.reversed()
                if (s1 == s2) {
                    cnt++
                }
            }
        }
        return cnt
    }
}