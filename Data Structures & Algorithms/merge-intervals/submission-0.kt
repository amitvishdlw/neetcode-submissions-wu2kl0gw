class Solution {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        intervals.sortWith(compareBy<IntArray> { it[0] }.thenBy { it[1] })
        return buildList<IntArray> { 
            intervals.forEachIndexed { i, interval ->
                if (isEmpty() || last()[1] < interval[0]) {
                    add(interval)
                } else {
                    last()[0] = minOf(last()[0], interval[0])
                    last()[1] = maxOf(last()[1], interval[1])    
                } 
            }
        }.toTypedArray()
    }
}
