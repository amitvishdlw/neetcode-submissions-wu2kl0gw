class Solution {
    fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
        return buildList {
            intervals.forEachIndexed { index, interval ->
                if (newInterval[1] < interval[0]) {
                    add(newInterval)
                    addAll(intervals.slice(index..intervals.lastIndex))
                    return@buildList
                } else if (newInterval[0] > interval[1]) {
                    add(interval)
                } else {
                    newInterval[0] = minOf(newInterval[0], interval[0])
                    newInterval[1] = maxOf(newInterval[1], interval[1])
                }
            }
            add(newInterval)
        }.toTypedArray()
    }
}