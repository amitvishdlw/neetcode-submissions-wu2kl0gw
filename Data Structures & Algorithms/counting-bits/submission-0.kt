class Solution {
    fun countBits(n: Int): IntArray {
        val res = IntArray(n+1) 
        for (i in (0..n)) {
            for (b in (0..31)) {
                val isSet = i and (1 shl b) != 0
                if (isSet) {
                    res[i]++
                }
            }
        }
        return res
    }
}
