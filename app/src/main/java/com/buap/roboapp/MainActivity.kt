package com.buap.roboapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun btnExampleMethod(view: View) {
        Toast.makeText(this, "Hello world", Toast.LENGTH_LONG).show()
    }
}
