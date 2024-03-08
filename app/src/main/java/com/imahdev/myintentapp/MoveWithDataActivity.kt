package com.imahdev.myintentapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MoveWithDataActivity : AppCompatActivity() {
    private lateinit var tvDataReceived: TextView

    //objek penampung data
    companion object {
        const val EXTRA_NAME = "default_name"
        const val EXTRA_AGE = "default Age"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_with_data)

        tvDataReceived = findViewById(R.id.tv_data_received)

        val name = intent.getStringExtra(EXTRA_NAME)
        val age = intent.getIntExtra(EXTRA_AGE, 0)

        val value = "Name : $name, Age: $age"
        tvDataReceived.text = value

    }
}