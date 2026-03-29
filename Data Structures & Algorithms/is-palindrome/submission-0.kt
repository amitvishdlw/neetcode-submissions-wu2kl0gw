class Solution {
    fun isPalindrome(s: String): Boolean {
        val ss = s.split(' ').flatMap { it.lowercase().toList() }.filter {
            it.isLetterOrDigit()
        }.joinToString("")
        return ss.equals(ss.reversed())
    }
}
