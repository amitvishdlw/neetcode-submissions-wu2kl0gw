class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val anagramIds = mutableMapOf<String, MutableList<String>>()
        strs.forEach { str ->
            val sortedStr = str.toCharArray().sorted().toString()
            val anagramsList = anagramIds.getOrDefault(sortedStr, mutableListOf<String>())
            anagramsList.add(str)
            anagramIds.put(sortedStr, anagramsList)
        }
        return buildList {
            return anagramIds.map { (_, ids) ->
                ids
            }
        }
    }
}
