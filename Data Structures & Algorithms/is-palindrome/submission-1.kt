class Solution {
    fun isPalindrome(s: String): Boolean {

        val ss = s
            .lowercase()
            .filter { it.isLetterOrDigit() }

        return ss == ss.reversed()
    }
}