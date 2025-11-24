package ie.tudublin

class Sudoku(rows: List<String>) {
    private val grid = IntArray(81)
    private var solved = false
    var iterations = 0

    init {
        require(rows.size == 9 && rows.all { it.length == 9 }) {
            "Grid must be 9 x 9"
        }
        for (i in 0..8) {
            for (j in 0..8 ) grid[9 * i + j] = rows[i][j] - '0'
        }
    }

    fun solve(maxIterations: Int = 2_000_000): Boolean {
        iterations = 0
        placeNumber(0, maxIterations)
        return solved
    }

    private fun placeNumber(pos: Int, maxIterations: Int) {
        if (solved) return
        if (iterations > maxIterations) return
        iterations++

        if (pos == 81) {
            solved = true
            return
        }

        if (grid[pos] > 0) {
            placeNumber(pos + 1, maxIterations)
            return
        }

        for (n in 1..9) {
            if (checkValidity(n, pos % 9, pos / 9)) {
                grid[pos] = n
                placeNumber(pos + 1, maxIterations)
                if (solved) return
                grid[pos] = 0
            }
        }
    }

    private fun checkValidity(v: Int, x: Int, y: Int): Boolean {
        for (i in 0..8) {
            if (grid[y * 9 + i] == v || grid[i * 9 + x] == v) return false
        }
        val startX = (x / 3) * 3
        val startY = (y / 3) * 3
        for (i in startY until startY + 3) {
            for (j in startX until startX + 3) {
                if (grid[i * 9 + j] == v) return false
            }
        }
        return true
    }

    fun printBoard() {
        for (i in 0..8) {
            for (j in 0..8) {
                print("${grid[i * 9 + j]} ")
                if (j == 2 || j == 5) print("| ")
            }
            println()
            if (i == 2 || i == 5) println("------+-------+------")
        }
    }

    companion object {
        fun loadBoardFromFile(filename: String): List<String> =
            java.io.File(filename).readLines().take(9)
    }
}

