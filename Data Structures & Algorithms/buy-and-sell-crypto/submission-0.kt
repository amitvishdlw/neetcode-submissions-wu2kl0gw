class Solution {
    fun maxProfit(prices: IntArray): Int {
        // min a[j] seen before a[i]
        var minPriceSeen: Int? = null
        var ans = 0
        prices.forEach { price ->
            minPriceSeen?.let {
                ans = max(ans, price - it)
            }
            
            if (minPriceSeen == null) {
                minPriceSeen = price
            } else {
                minPriceSeen = min(minPriceSeen!!, price)
            }
        }
        return ans
    }
}
