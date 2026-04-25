/**
 * Definition of Interval:
 * class Interval(var start: Int, var end: Int) {}
 */

class Solution {
    fun canAttendMeetings(intervals: List<Interval>): Boolean {
        intervals.forEachIndexed { currentIndex, currentInterval ->
            intervals.forEachIndexed { index, interval ->
                if (currentIndex != index
                    && (
                            (currentInterval.start in interval.start..< interval.end)
                                    || currentInterval.end in (interval.start + 1)..interval.end)
                ) {
                    return false
                }
            }
        }
        return true
    }
}