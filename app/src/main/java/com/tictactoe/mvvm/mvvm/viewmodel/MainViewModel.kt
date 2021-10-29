package com.example.androidbootcamp2021.mvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tictactoe.mvvm.mvvm.model.Board
import com.tictactoe.mvvm.mvvm.model.Player

class MainViewModel : ViewModel(), InterfaceViewModel {

    var model: Board = Board()
    var isInitialize = false
    var cells: Array<Array<MutableLiveData<String>>> = Array(3) {
        Array(3) {
            MutableLiveData<String>()
        }
    }
    var winner: MutableLiveData<String> = MutableLiveData()
    var isShowWinner: MutableLiveData<Boolean> = MutableLiveData()

    override fun onCreate() {
        if (!isInitialize) {
            isInitialize = true
            for (i in 0 until 3) {
                for (j in 0 until 3) {
                    cells[i][j].value = ""
                }
            }
            winner.value = ""
            isShowWinner.value = false
        }
    }

    override fun onResume() {

    }
    override fun onPause() {

    }
    override fun onDestroy() {

    }


    fun onClickButton(row: Int, col: Int) {
        var player: Player = model.mark(row, col)
        if (player != Player.NULL) {
            cells[row][col].postValue(player.toString())
            if (model.getWinner(row, col, player) != Player.NULL) {
                winner.postValue(player.toString())
                isShowWinner.postValue (true)
            } else {
                model.flipPlayer()
            }
        }
    }

    fun resetAll() {
        winner.postValue("")
        isShowWinner.postValue(false)
        for (i in 0 until 3) {
            for (j in 0 until 3) {
                cells[i][j].value = ""
            }
        }
        model.clearCells()
    }
}