class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val anagramIds = mutableMapOf<String, List<String>>()
        strs.forEach { str ->
            val sortedStr = str.toCharArray().sorted().toString()
            anagramIds.put(sortedStr, anagramIds.getOrDefault(sortedStr, emptyList()) + listOf(str))
        }
        return buildList {
            return anagramIds.map { (_, ids) ->
                ids
            }
        }
    }
}
