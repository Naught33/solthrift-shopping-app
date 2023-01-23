package com.example.solthrift

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class adminn_account_login : AppCompatActivity() {
    lateinit var username:EditText
    lateinit var password:EditText
    lateinit var login:Button
    lateinit var next:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adminn_account_login)

        username = findViewById(R.id.username2_edt)
        password = findViewById(R.id.pass_edt)
        login = findViewById(R.id.login_btn)
        next = findViewById(R.id.next)
        next.setOnClickListener {
            startActivity(Intent(this, upload_activity::class.java))
        }

        login.setOnClickListener {
            validateFields()
        }
    }

    private fun validateFields() {
        val username = username.text.toString()
        val pass = password.text.toString()

        if (username.isNotEmpty() && pass.isNotEmpty()){
            startActivity(Intent(this, admin_main::class.java))
        }else{
            if (username.isEmpty() or pass.isEmpty()){
                Toast.makeText(this, "fill in all fields", Toast.LENGTH_SHORT).show()
            }
        }
    }
}