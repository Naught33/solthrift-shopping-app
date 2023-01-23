package com.example.solthrift

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    lateinit var shopper_button:Button
    lateinit var admin_button:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        supportActionBar?.hide()

        shopper_button = findViewById(R.id.shopper_btn)
        admin_button = findViewById(R.id.admin_btn)

        shopper_button.setOnClickListener {
            startActivity(Intent(this, shopper::class.java))
        }
        admin_button.setOnClickListener {
            startActivity(Intent(this, admin_login::class.java))
        }

    }
}