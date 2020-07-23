package com.example.gamesuit

import Pemain
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main_vs_cpu.*
import kotlinx.android.synthetic.main.activity_main_vs_pemain.*
import kotlinx.android.synthetic.main.activity_main_vs_pemain.iv_batu
import kotlinx.android.synthetic.main.activity_main_vs_pemain.iv_gunting
import kotlinx.android.synthetic.main.activity_main_vs_pemain.iv_kertas
import kotlinx.android.synthetic.main.activity_main_vs_pemain.iv_restart
import kotlinx.android.synthetic.main.activity_main_vs_pemain.tv_pemenang

class MainActivityVsCpu : AppCompatActivity() {

    var pemain = Pemain()
    var pemain1 = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_vs_cpu)

        iv_batu.setOnClickListener {
            pemain1 = pemain.permainan[1]
            tampilPemain()
        }
        iv_gunting.setOnClickListener {
            pemain1 = pemain.permainan[0]
            tampilPemain()
        }
        iv_kertas.setOnClickListener {
            pemain1 = pemain.permainan[2]
            tampilPemain()
        }
        iv_home.setOnClickListener {
            val homeIntent = Intent(this@MainActivityVsCpu, Menu::class.java)
            startActivity(homeIntent)
        }
        iv_restart.setOnClickListener {
            reset()
        }
        iv_cpuClose.setOnClickListener {
            val closeIntent = Intent(this@MainActivityVsCpu, ExitActivity::class.java)
            startActivity(closeIntent)
        }
    }

    fun reset() {
        pemain = Pemain()
        pemain1 = ""
        tv_pemenang.text = "Mulai Permainan"
    }

    fun tampilPemain() {
        Toast.makeText(this, "Pemain 1 : $pemain1 ", Toast.LENGTH_LONG).show()
        val hasil = pemain.hasilCpu(pemain1)
        tv_pemenang.text = hasil
    }
}