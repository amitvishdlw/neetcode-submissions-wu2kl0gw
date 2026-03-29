class Solution {
    fun isValid(s: String): Boolean {
        val d = ArrayDeque<Char>()
        s.forEach { c ->
            when(c) {
                '(', '[', '{' -> d.addLast(c)
                else -> {
                    if (d.isEmpty()) return false
                    val topChar = d.removeLast()
                    if (c == ')' && topChar != '(' || c == ']' && topChar != '[' || c == '}' && topChar != '{') {
                        return false
                    }
                }
            }
        }
        return d.isEmpty()
    }
}