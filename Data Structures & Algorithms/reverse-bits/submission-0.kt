class Solution {
    fun reverseBits(n: Int): Int {
        var res = 0
        for (b in (0..31)) {
            val isSet = (n and (1 shl b)) != 0
            if (isSet) {
                res += 1 shl (31-b)
            }
        }
        return res
    }
}
