package com.tictactoe.mvvm.mvvm.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.example.androidbootcamp2021.mvvm.viewmodel.MainViewModel
import com.tictactoe.mvvm.R
import com.tictactoe.mvvm.databinding.ActivityTicTacToeMvvmBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityTicTacToeMvvmBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_tic_tac_toe_mvvm)
        binding.lifecycleOwner = this
        binding.mainViewModel = viewModel
        viewModel.onCreate()
    }
    override fun onResume() {
        super.onResume()
        viewModel.onResume()
    }
    override fun onPause() {
        super.onPause()
        viewModel.onPause ()
    }
    override fun onDestroy() {
        super.onDestroy()
        viewModel.onDestroy ()
    }
}

