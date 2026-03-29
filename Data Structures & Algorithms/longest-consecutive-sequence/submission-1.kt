class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        val ds = UF(nums)
        nums.forEach { num ->
            if (ds.pr.containsKey(num-1)) {
                ds.union(num, num-1)
            }
            if (ds.pr.containsKey(num+1)) {
                ds.union(num,num+1)
            }
        }
        return ds.sz.values.maxOrNull()?:0
    }
}

class UF(private val nums: IntArray) {
    val pr = mutableMapOf<Int,Int>()
    val sz = mutableMapOf<Int,Int>()

    init {
        nums.forEach { 
            pr[it] = it
            sz[it] = 1
        }
    }

    fun root(x: Int): Int {
        if (x == pr[x]) return x
        pr[x] = root(pr[x]!!)
        return pr[x]!!
    }

    fun union(x: Int, y: Int) {
        val rx = root(x)
        var ry = root(y)
        if (rx == ry) return
        pr[rx] = ry
        sz[ry] = sz[ry]!! + sz[rx]!!
    }
}