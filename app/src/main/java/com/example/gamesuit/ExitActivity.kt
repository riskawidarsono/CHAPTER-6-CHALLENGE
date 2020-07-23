package com.example.gamesuit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_exit.*

class ExitActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exit)

        tv_keluarApp.setOnClickListener {
            finish()
        }
        tv_mulaiApp.setOnClickListener {
            onRestart()
        }
    }
}