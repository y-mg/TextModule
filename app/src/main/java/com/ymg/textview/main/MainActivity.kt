package com.ymg.textview.main


import android.os.Bundle
import com.ymg.textview.databinding.ActivityMainBinding


class MainActivity : BasicActivity() {

    private lateinit var viewBinding: ActivityMainBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
    }
}