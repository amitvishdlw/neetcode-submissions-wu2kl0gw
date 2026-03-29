class Solution {
    fun setZeroes(matrix: Array<IntArray>) {
        val rowSet = HashSet<Int>()
        val colSet = HashSet<Int>()
        for (i in matrix.indices) {
            for (j in matrix[i].indices) {
                if (matrix[i][j] == 0) {
                    rowSet.add(i)
                    colSet.add(j)
                }
            }
        }

        for (i in matrix.indices) {
            for (j in matrix[i].indices) {
                if (rowSet.contains(i) || colSet.contains(j)) {
                    matrix[i][j] = 0
                }
            }
        }
    }
}
