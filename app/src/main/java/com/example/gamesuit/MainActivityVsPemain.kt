package com.example.gamesuit

import Pemain
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main_vs_cpu.*
import kotlinx.android.synthetic.main.activity_main_vs_pemain.*
import kotlinx.android.synthetic.main.activity_main_vs_pemain.iv_batu
import kotlinx.android.synthetic.main.activity_main_vs_pemain.iv_batu1
import kotlinx.android.synthetic.main.activity_main_vs_pemain.iv_gunting
import kotlinx.android.synthetic.main.activity_main_vs_pemain.iv_gunting1
import kotlinx.android.synthetic.main.activity_main_vs_pemain.iv_kertas
import kotlinx.android.synthetic.main.activity_main_vs_pemain.iv_kertas1
import kotlinx.android.synthetic.main.activity_main_vs_pemain.iv_restart
import kotlinx.android.synthetic.main.activity_main_vs_pemain.tv_pemenang

class MainActivityVsPemain : AppCompatActivity() {

    var pemain = Pemain()
    var pemain1 = ""
    var pemain2 = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_vs_pemain)
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
        iv_batu1.setOnClickListener {
            pemain2 = pemain.permainan[1]
            tampilPemain()
        }
        iv_gunting1.setOnClickListener {
            pemain2 = pemain.permainan[0]
            tampilPemain()
        }
        iv_kertas1.setOnClickListener {
            pemain2 = pemain.permainan[2]
            tampilPemain()
        }
        iv_homePemain.setOnClickListener {
            val intent = Intent(this@MainActivityVsPemain, Menu::class.java)
            startActivity(intent)
        }
        iv_pemainClose.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Memulai Aplikasi")
            builder.setTitle("Anda Keluar Aplikasi?")
            builder.setPositiveButton("Yes") { dialog: DialogInterface, which: Int ->
                finish()
            }
            builder.setNegativeButton("No") { dialog: DialogInterface, which: Int ->
                builder.show()
            }


            val closeIntent = Intent(this@MainActivityVsPemain, ExitActivity::class.java)
            startActivity(closeIntent)
        }
        iv_restart.setOnClickListener {
            reset()
        }


    }

    fun reset() {
        pemain = Pemain()
        pemain1 = ""
        pemain2 = ""
        tv_pemenang.text = "Mulai Permainan"
    }

    fun tampilPemain() {
        Toast.makeText(this, "Pemain 1 : $pemain1 Pemain 2 : $pemain2", Toast.LENGTH_LONG).show()
        val hasil = pemain.hasil(pemain1, pemain2)
        tv_pemenang.text = hasil

    }

}
