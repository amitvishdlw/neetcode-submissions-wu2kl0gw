class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        val ds = UF(nums)
        nums.forEach { num -> 
            if (ds.pr.containsKey(num-1)) {
                ds.union(num, num - 1)
            }

            if (ds.pr.containsKey(num+1)) {
                ds.union(num, num + 1)
            }
        }

        return ds.sz.values.maxOrNull() ?: 0
    }
}

class UF(nums: IntArray) {

    val pr = mutableMapOf<Int, Int>()
    val sz = mutableMapOf<Int, Int>()

    init {
        nums.forEach {
            pr[it] = it
            sz[it] = 1
        }
    }

    private fun isRoot(x: Int) = pr[x] == x

    fun root(x: Int): Int {
        if (isRoot(x)) return x

        pr[x] = root(pr[x]!!)
        return pr[x]!!
    }

    fun union(x: Int, y: Int) {

        val xr = root(x)
        val yr = root(y)

        if (xr == yr) return

        var xRoot = xr
        var yRoot = yr

        if (sz[xRoot]!! < sz[yRoot]!!) {
            val temp = xRoot
            xRoot = yRoot
            yRoot = temp
        }

        pr[yRoot] = xRoot
        sz[xRoot] = sz[xRoot]!! + sz[yRoot]!!
    }
}