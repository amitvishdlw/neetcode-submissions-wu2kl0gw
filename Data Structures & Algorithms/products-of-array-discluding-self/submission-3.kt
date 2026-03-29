class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        val zerosCount = nums.count { it == 0 }
        return when {
            zerosCount == 0 -> {
                var prod = 1
                nums.forEach {
                    prod *= it
                }
                val res = IntArray(nums.size) { 0 }
                nums.forEachIndexed { i, num ->
                    res[i] = prod / num
                }
                res
            }
            
            zerosCount == 1 -> {
                var prod = 1
                nums.filter { it != 0 }.forEach {
                    prod *= it
                }
                val res = IntArray(nums.size) { 0 }
                nums.forEachIndexed { i, num ->
                    if (num == 0) {
                        res[i] = prod
                    }
                }
                res
            }

            else -> {
                IntArray(nums.size) { 0 } 
            }
        }
    }
}
