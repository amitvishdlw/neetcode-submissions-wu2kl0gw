class Solution {
    fun countBits(n: Int): IntArray {
        return IntArray(n+1) { it.countOneBits() }
    }
}
