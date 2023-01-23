package com.example.solthrift

import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.View.VISIBLE
import android.widget.ProgressBar
import androidx.constraintlayout.widget.ConstraintSet
import androidx.constraintlayout.widget.ConstraintSet.VISIBLE
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlin.time.Duration.Companion.milliseconds

class shopper : AppCompatActivity() {
    lateinit var database: FirebaseDatabase
    lateinit var recyclerView: RecyclerView
    lateinit var pbar:ProgressBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopper)
        database = FirebaseDatabase.getInstance()
        recyclerView = findViewById(R.id.recycler)
        recyclerView.layoutManager = LinearLayoutManager(this)
        pbar = findViewById(R.id.progressanim)
        preview()
        pbar.visibility=View.INVISIBLE


    }

    private fun preview() {
        val databaseref = database.getReference("goods/uploaded")
        databaseref.addValueEventListener(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()){
                    for (data in snapshot.children){
                        val array = arrayListOf<UploadItems>()
                        array.clear()
                        val good = data.getValue(UploadItems::class.java)
                        recyclerView.adapter = RecyclerViewAdapter(array)
                        array.add(good!!)

                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })



    }

}