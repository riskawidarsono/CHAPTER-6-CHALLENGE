package com.example.gamesuit

import android.annotation.SuppressLint
import android.app.ProgressDialog.show
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val username = "riskawidarsono@gmail.com"
        val password = "widarsono"
        val sharedPreferences = getSharedPreferences("userLogin", Context.MODE_PRIVATE)

        btnLogin.setOnClickListener {
            if (inputUsername.text.toString() == username && inputPassword.text.toString() == password) {
                if (containerPassword.isEndIconCheckable) {
                    val editor = sharedPreferences.edit()
                    editor.putString("user_KEY", username)
                    editor.putString("password_KEY", password)
                    editor.putString("name", "riska")
                    editor.apply()
                }

                val intent = Intent(this, Menu::class.java)
                startActivity(intent)
                finish()
                Toast.makeText(this, "Login Berhasil", Toast.LENGTH_SHORT)
                    .show()

            } else if (inputUsername.text.toString().isEmpty() && inputPassword.text.toString()
                    .isEmpty()
            ) {
                Toast.makeText(
                    this,
                    "Username or Password Harus Wajib Diisikan",
                    Toast.LENGTH_SHORT
                )
                    .show()
            } else {
                Toast.makeText(this, "Login Gagal", Toast.LENGTH_SHORT)
                    .show()
            }
        }
        btnRestart.setOnClickListener {
            inputUsername.setText("")
            inputPassword.setText("")
        }
    }

}
