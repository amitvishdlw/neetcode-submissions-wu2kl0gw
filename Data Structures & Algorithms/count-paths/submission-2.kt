class Solution {
    fun uniquePaths(m: Int, n: Int): Int {
        val seqLength = m + n - 2
        val choose = minOf(m, n) - 1
        return nCr(seqLength, choose)
    }

    fun nCr(n: Int, r: Int): Int {
        var num = 1L
        var den = 1L
        for (i in 1..r) {
            num *= (n - i + 1).toLong()
            den *= i.toLong()
            if (num % i == 0L) {
                num /= i
                den /= i
            }
        }
        return (num/den).toInt()
    }
}
