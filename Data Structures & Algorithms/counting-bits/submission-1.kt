class Solution {
    fun countBits(n: Int): IntArray {
        val res = IntArray(n+1) 
        for (i in (0..n)) {
            var num = i
            while (num != 0) {
                res[i]++
                num = num and (num-1)
            }
        }
        return res
    }
}
