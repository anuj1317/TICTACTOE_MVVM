package com.tictactoe.mvvm.mvvm.model

class Board {

    var currentPlayer: Player = Player.X
    var cells: Array<Array<Cell>> = Array(3) {
        Array(3) { Cell()
        }
    }


    //Getting current player and the cell he had marked
    fun mark(row: Int, col: Int): Player {
        if (isValid(row, col)) {
            cells[row][col].player = currentPlayer
            return currentPlayer
        }
        else {
            return Player.NULL
        }
    }


    fun isValid(row: Int, col: Int): Boolean {
        return cells[row][col].player == Player.NULL
    }

    //Flipping Players
    fun flipPlayer() {
        if (currentPlayer == Player.X)
            currentPlayer = Player.O
        else currentPlayer = Player.X
    }

    //Getting Winner by checking rows,columns and diagonally
    fun getWinner(row: Int, col: Int, player: Player): Player {
        if (cells[row][0].player == player &&
            cells[row][1].player == player &&
            cells[row][2].player == player ||
            cells[0][col].player == player &&
            cells[1][col].player == player &&
            cells[2][col].player == player ||
            row == col &&
            cells[0][0].player == player &&
            cells[1][1].player == player &&
            cells[2][2].player == player ||
            row + col == 2 &&
            cells[0][2].player == player &&
            cells[1][1].player == player &&
            cells[2][0].player == player
        ) {
            return player
        } else {
            return Player.NULL
        }
    }


    //Clearing cells
    fun clearCells() {
        currentPlayer = Player.X
        cells = Array(3) {
            Array(3) {
                Cell()
            }
        }

            }
        }



