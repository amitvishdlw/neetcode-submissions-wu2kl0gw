class Solution {
    fun isValid(s: String): Boolean {
        val d = ArrayDeque<Char>()
        val closeToOpen = mapOf(
            ')' to '(',
            ']' to '[',
            '}' to '{',
        )
        s.forEach { c ->
            when {
                c !in closeToOpen  -> d.addLast(c)
                else -> {
                    if (d.isEmpty()) return false
                    val topChar = d.removeLast()
                    if (closeToOpen[c] != topChar) {
                        return false
                    }
                }
            }
        }
        return d.isEmpty()
    }
}