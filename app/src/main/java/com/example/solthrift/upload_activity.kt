package com.example.solthrift

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import com.google.firebase.database.FirebaseDatabase

class upload_activity : AppCompatActivity() {

    lateinit var firebaseDatabase:FirebaseDatabase
    lateinit var upload: Button
    lateinit var name:EditText
    lateinit var image: ImageView
    lateinit var description:EditText
    lateinit var price:EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_upload)
        firebaseDatabase = FirebaseDatabase.getInstance()
        upload = findViewById(R.id.button)
        name = findViewById(R.id.name)
        description = findViewById(R.id.desc)
        price = findViewById(R.id.price)
        image = findViewById(R.id.imageView2)
        upload.setOnClickListener {
            val name = name.text.toString()
            val description = description.text.toString()
            val price = price.text.toString()
            var databaseref = firebaseDatabase.getReference("goods/uploaded/$name")
            databaseref.setValue(UploadItems(name,description,"Ksh $price"))
        }

    }
}