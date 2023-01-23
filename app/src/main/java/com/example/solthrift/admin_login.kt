package com.example.solthrift

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class admin_login : AppCompatActivity() {

    lateinit var firebaseAuth: FirebaseAuth
    lateinit var firebasedatabse: FirebaseDatabase

    lateinit var username:EditText
    lateinit var createpass:EditText
    lateinit var confirmpass:EditText
    lateinit var signup:Button
    lateinit var login:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_login)

        firebaseAuth = FirebaseAuth.getInstance()
        firebasedatabse = FirebaseDatabase.getInstance()

        username  = findViewById(R.id.username_edt)
        createpass  = findViewById(R.id.createpass_edt)
        confirmpass  = findViewById(R.id.confirmpass_edt)
        signup  = findViewById(R.id.signupbtn)
        login = findViewById(R.id.login_txt)



        login.setOnClickListener {
            startActivity(Intent(this, adminn_account_login::class.java))
        }
        signup.setOnClickListener {
            validateCredentials()
            signUpUser()
        }

    }

    private fun updateDatabase() {
        val username = username.text.toString()
        val pass = createpass.text.toString()


      val databaseref =   firebasedatabse.getReference("users/$username")
        databaseref.setValue(credentials(username, pass))


    }

    private fun signUpUser() {
        val username = username.text.toString()
        val pass = createpass.text.toString()
//        firebasedatabse.getReference("users/$username").addValueEventListener(object: ValueEventListener{
//            override fun onDataChange(snapshot: DataSnapshot) {
//                for (data in snapshot.children){
//                  val mydata =  firebasedatabse.getReference("users/$username/username").get()
//                    val data = arrayOf(mydata)
//
//                }
//            }
//
//            override fun onCancelled(error: DatabaseError) {
//            }
//
//        })




    }

    private fun validateCredentials() {
        val username = username.text.toString()
        val pass = createpass.text.toString()
        val confirmpass = confirmpass.text.toString()


        if (pass ==confirmpass && pass.isNotEmpty() && confirmpass.isNotEmpty()){
            if(username.isNotEmpty()){
                updateDatabase()
                startActivity(Intent(this, admin_main::class.java))
            }else{
                if (pass.isEmpty() or confirmpass.isEmpty() or username.isEmpty()) {
                    Toast.makeText(this, "fill in all fields", Toast.LENGTH_SHORT).show()
                }
            }
        }else{
            if (pass != confirmpass) {
                Toast.makeText(this, "passwords do not match", Toast.LENGTH_SHORT).show()
            }
        }


    }
}




