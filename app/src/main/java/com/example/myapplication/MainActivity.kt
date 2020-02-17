package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.afollestad.vvalidator.form
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        form {
            input(etFirstname) {
                isNotEmpty()
            }
            input(etLastname) {
                isNotEmpty()
            }
            input(etEmail) {
                isNotEmpty()
                isEmail()
            }
            input(etPhone) {
                isNotEmpty()
                matches("\\+?([ -]?\\d+)+|\\(\\d+\\)([ -]\\d+)")
            }
            input(etPassword) {
                isNotEmpty()
                length().atLeast(6)
            }
            submitWith(btnSave) { result ->
                // this block is only called if form is valid.
                // do something with a valid form state.
                Log.d("FORM", "the form is submitted")
            }
        }

//        btnSave.setOnClickListener {
//            if (etFirstname.text.isBlank()) {
//                Toast.makeText(this, "Hi there! This is a Toast 1", Toast.LENGTH_SHORT).show()
//            } else {
//                Toast.makeText(this, "Hi there! This is a Toast 2", Toast.LENGTH_SHORT).show()
//            }
//        }
    }
}
