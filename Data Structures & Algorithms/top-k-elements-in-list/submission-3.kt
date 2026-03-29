class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val count = HashMap<Int, Int>()
        for (num in nums) {
            count[num] = count.getOrDefault(num, 0) + 1
        }

        val heap = PriorityQueue<Pair<Int, Int>>(compareBy { it.first })
        for ((num, freq) in count) {
            heap.add(Pair(freq, num))
            if (heap.size > k) {
                heap.poll()
            }
        }

        val res = IntArray(k)
        for (i in k - 1 downTo 0) {
            res[i] = heap.poll().second
        }
        return res
    }
}