class Solution {
    fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
        return buildList {
            // i'th non overlapping interval which comes before nStart
            // j'th non overlapping interval which comes after nEnd
            // (i+1..j-1) will be the merged interval
            if (intervals.isEmpty()) {
                add(newInterval)
                return@buildList
            }
            
            val i: Int = run {
                var res = -1
                intervals.forEachIndexed { index, interval ->
                    if (interval[1] < newInterval[0]) {
                        res = index
                    }
                }
                return@run res
            }

            val j: Int = run {
                intervals.forEachIndexed { index, interval ->
                    if (interval[0] > newInterval[1]) {
                        return@run index
                    }
                }
                return@run -1
            }

            if (i != -1) {
                addAll(intervals.slice(0..i))
            }

            val bStart = if (i+1 in intervals.indices) intervals[i+1][0] else newInterval[0]
            val bEnd = if (j-1 in intervals.indices) intervals[j-1][1] else if (j == -1) intervals.last()[1] else newInterval[1]

            add(intArrayOf(
                minOf(newInterval[0], bStart),
                maxOf(newInterval[1], bEnd),
            ))

            if (j != -1) {
                addAll(intervals.slice(j..intervals.lastIndex))
            }
        }.toTypedArray()
    }

    private companion object {
        private const val N = 1005
    }
}