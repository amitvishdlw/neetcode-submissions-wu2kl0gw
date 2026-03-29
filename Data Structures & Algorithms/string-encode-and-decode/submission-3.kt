class Solution {
    fun encode(strs: List<String>): String {
        return buildString {
            strs.forEach { str ->
                str.forEach { c ->
                    append("*")
                    append(c)
                }
                append("--")
            }
        }
    }

    fun decode(str: String): List<String> {
        return buildList {
            val n = str.length
            val word = mutableListOf<Char>()
            for (i in 0 until n step 2) {
                val a = str[i]
                val b = str[i+1]
                if (a == '-' && b == '-') {
                    add(word.joinToString(""))
                    word.clear()
                } else {
                    word.add(b)
                }
            }
        }
    }
}
