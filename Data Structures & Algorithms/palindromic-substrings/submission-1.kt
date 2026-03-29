class Solution {
    fun countSubstrings(s: String): Int {
        val n = s.length
        var cnt = 0
        for (i in 0..<n) {
            for (j in i..<n) {
                if (isPalin(s,i,j)) {
                    cnt++
                }
            }
        }
        return cnt
    }

    fun isPalin(s: String, start: Int, end: Int): Boolean {
        var i = start
        var j = end
        while (true) {
            if (i <= j && s[i] == s[j]) {
                i++
                j--
            } else if (i <= j && s[i] != s[j]) {
                return false
            } else {
                break
            }
        }
        return true
    }
}