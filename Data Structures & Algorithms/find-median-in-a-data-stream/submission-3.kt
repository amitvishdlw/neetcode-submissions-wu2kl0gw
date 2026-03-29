class MedianFinder {
    private val left = PriorityQueue<Int>(compareByDescending {it} )
    private val right = PriorityQueue<Int>()

    fun addNum(num: Int) {
        val lsz = left.size
        val rsz = right.size
        if (lsz == rsz) {
            left.add(num)
            right.add(left.poll())
            left.add(right.poll())
        } else if (lsz == rsz + 1) {
            right.add(num)
            left.add(right.poll())
            right.add(left.poll())
        }
    }

    fun findMedian(): Double {
        val lsz = left.size
        val rsz = right.size
        return if ((lsz + rsz) % 2 == 0) {
            ((left.peek() ?: 0) + (right.peek() ?: 0)) / 2.toDouble()
        } else {
            left.peek().toDouble()
        }
    }
}
