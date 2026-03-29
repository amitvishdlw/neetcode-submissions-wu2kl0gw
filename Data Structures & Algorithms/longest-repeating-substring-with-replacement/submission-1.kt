class Solution {
    fun characterReplacement(s: String, k: Int): Int {
        val b = Bag(k)
        var ans = 0
        s.forEach { c ->
            b.add(c)
        }
        return b.getAns()
    }

    class Bag(private val k: Int) {
        private val list = ArrayDeque<Char>()
        private val freq = mutableMapOf<Char,Int>()
        private var ans = 0

        fun getAns(): Int = ans

        fun add(c: Char) {
            list.addLast(c)
            freq[c] = freq.getOrDefault(c, 0) + 1
            var freqMax = freq.values.maxOrNull() ?: 0

            while(!list.isEmpty && list.size - freqMax > k) {
                val firstC = list.first
                list.removeFirst()
                freq[firstC] = freq.getOrDefault(firstC, 0) - 1
                freqMax = freq.values.maxOrNull() ?: 0
            }

            ans = max(ans, list.size)
        }
    }
}
