class Solution {
    fun minWindow(s: String, t: String): String {
        val b = Bag(t)
        s.forEach { c ->
            b.add(c)
        }
        return b.result
    }

    class Bag(private val t: String) {
        private val freqT = t.groupingBy {it}.eachCount()
        private val freqC = mutableMapOf<Char, Int>()
        private val list = ArrayDeque<Char>()
        var result = ""

        fun add(c: Char) {
            list.addLast(c)
            freqC[c] = freqC.getOrDefault(c, 0) + 1
            while (isValid()) {
                result = if (result.isEmpty() || result.length > list.size) {
                    list.joinToString("")
                } else result
                val firstC = list.first()
                list.removeFirst()
                freqC[firstC] = freqC.getOrDefault(firstC, 0) - 1
            }
        }

        private fun isValid(): Boolean {
            for((c, cnt) in freqT) {
                if (freqC.getOrDefault(c, 0) < cnt) {
                    return false
                }
            }
            return true
        }
    }
}
