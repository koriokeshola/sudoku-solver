package ie.tudublin

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class SudokuTest {

    @Test
    fun testSolvableBoard1() {
        val board = arrayOf(
            intArrayOf(0,0,0,0,0,0,0,1,2),
            intArrayOf(0,0,0,0,0,0,0,0,0),
            intArrayOf(0,0,1,0,2,0,0,0,0),
            intArrayOf(0,0,0,0,0,0,3,0,0),
            intArrayOf(0,0,0,4,0,5,0,0,0),
            intArrayOf(0,0,6,0,0,0,0,0,0),
            intArrayOf(0,0,0,0,3,0,7,0,0),
            intArrayOf(0,0,0,0,0,0,0,0,0),
            intArrayOf(8,9,0,0,0,0,0,0,0)
        )
        val sudoku = Sudoku(board)
        val solved = sudoku.solve()
        assertTrue(solved)
    }

    @Test
    fun testSolvableBoard2() {
        val board = arrayOf(
            intArrayOf(0,2,0,6,0,8,0,0,0),
            intArrayOf(5,8,0,0,0,9,7,0,0),
            intArrayOf(0,0,0,0,4,0,0,0,0),
            intArrayOf(3,7,0,0,0,0,5,0,0),
            intArrayOf(6,0,0,0,0,0,0,0,4),
            intArrayOf(0,0,8,0,0,0,0,1,3),
            intArrayOf(0,0,0,0,2,0,0,0,0),
            intArrayOf(0,0,9,8,0,0,0,3,6),
            intArrayOf(0,0,0,3,0,6,0,9,0)
        )
        val sudoku = Sudoku(board)
        val solved = sudoku.solve()
        assertTrue(solved)
    }

    @Test
    fun testUnsolvableBoard() {
        val board = Array(9) { IntArray(9) { 1 } }
        val sudoku = Sudoku(board)
        val solved = sudoku.solve()
        assertFalse(solved)
    }
}

