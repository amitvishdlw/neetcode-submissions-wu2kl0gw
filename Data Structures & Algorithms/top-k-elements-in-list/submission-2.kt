class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val freq = mutableMapOf<Int, Int>()
        nums.forEach { num ->
            freq[num] = freq.getOrDefault(num,0) + 1
        }

        val sortedFreqList = freq.toList().sortedByDescending { it.second }
        return sortedFreqList.take(k).map { it.first }.toIntArray()
    }
}
