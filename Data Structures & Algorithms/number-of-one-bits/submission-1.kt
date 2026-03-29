class Solution {
    fun hammingWeight(n: Int): Int {
        var x = n
        var res = 0
        while (x != 0) {
            res++
            x = x and (x-1)
        }
        return res
    }
}
