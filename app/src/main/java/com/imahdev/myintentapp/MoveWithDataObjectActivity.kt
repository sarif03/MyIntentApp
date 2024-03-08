package com.imahdev.myintentapp

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MoveWithDataObjectActivity : AppCompatActivity() {


    companion object {
        const val EXTRA_PERSON = "extra_person"
    }

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_with_data_object)

        val tvObjectReceived: TextView = findViewById(R.id.tv_object_received)

        // Pengecekan & penyesuaian versi Android yg dipakai User
        val person = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Person>(EXTRA_PERSON, Person::class.java)
        } else {
            intent.getParcelableExtra<Person>(EXTRA_PERSON)
        }

        if (person != null) {
            tvObjectReceived.text = " Name : ${person.name}\n Umur : ${person.age}\n Email : ${person.email}\n Kota : ${person.city}"
        }


    }
}