class Solution {
    fun isValid(s: String): Boolean {
        val d = ArrayDeque<Char>()
        s.forEach { c ->
            when(c) {
                '(' -> d.addLast('(')
                '[' -> d.addLast('[')
                '{' -> d.addLast('{')
                ')' -> if (!d.isEmpty() && d.last() == '(') { d.removeLast() } else return false
                ']' -> if (!d.isEmpty() && d.last() == '[') { d.removeLast() } else return false
                '}' -> if (!d.isEmpty() && d.last() == '{') { d.removeLast() } else return false
                else -> Unit
            }
        }
        return d.isEmpty()
    }
}