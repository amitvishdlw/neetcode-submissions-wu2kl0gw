class Solution {
    fun encode(strs: List<String>): String {
        return buildString {
            strs.forEach { str ->
                append("--")
                str.toCharArray().map { c ->
                    append("*")
                    append(c)
                }
            }
            if (strs.size > 0) {
                append("--")
            }
        }
    }

    fun decode(str: String): List<String> {
        return buildList {
            val n = str.length
            val word = mutableListOf<Char>()
            var isFirstDelim = true
            for (i in 0 until n step 2) {
                val a = str[i]
                val b = str[i+1]
                if (!isFirstDelim && a == '-' && b == '-') {
                    add(word.joinToString(""))
                    word.clear()
                } else if (isFirstDelim){
                    isFirstDelim = false
                } else {
                    word.add(b)
                }
            }
        }
    }
}
