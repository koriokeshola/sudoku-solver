package ie.tudublin

fun main(args: Array<String>) {
    if (args.isEmpty()) {
        println("Usage: <program> <input_file>")
        return
    }

    val filename = args[0]

    val board: List<String>
    try {
        board = Sudoku.loadBoardFromFile(filename)
    } catch (e: Exception) {
        println("Error reading file: ${e.message}")
        return
    }

    val sudoku = Sudoku(board)

    println("Input board:")
    sudoku.printBoard()

    val solved = sudoku.solve()

    if (solved) {
        println("\nSolved board:")
        sudoku.printBoard()
    } else {
        println("\nCould not find a solution. Iterations exceeded ${sudoku.iterations}")
    }
}

