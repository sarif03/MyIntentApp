package com.imahdev.myintentapp

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var btnMoveActivity: Button
    private lateinit var btnMoveWithData: Button
    private lateinit var btnMoveWithObject: Button
    private lateinit var btnDialNumber: Button
    private lateinit var btnMoveForResult: Button
    private lateinit var tvResult: TextView

    // Membuat objek ActivityResultLauncher agar digunakan untuk mengambil nilai kembalian.
    @SuppressLint("SetTextI18n")
    private var resultLauncher: ActivityResultLauncher<Intent> = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == MoveForResultActivity.RESULT_CODE && result.data != null) {
            val selectedValue = result.data!!.getIntExtra(MoveForResultActivity.EXTRA_SELECTED_VALUE, 0)
            tvResult.text = "Hasil : $selectedValue"
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvResult = findViewById(R.id.tv_result)
        btnMoveActivity = findViewById(R.id.btn_move_activity)
        btnMoveWithData = findViewById(R.id.btn_move_with_data)
        btnMoveWithObject = findViewById(R.id.btn_move_with_object)
        btnDialNumber = findViewById(R.id.btn_dial_number)
        btnMoveForResult = findViewById(R.id.btn_move_for_result)

        //action click
        btnMoveActivity.setOnClickListener(this)
        btnMoveWithData.setOnClickListener(this)
        btnMoveWithObject.setOnClickListener(this)
        btnDialNumber.setOnClickListener(this)
        btnMoveForResult.setOnClickListener(this)

    }

    override fun onClick(view: View) {

        when(view.id) {
            R.id.btn_move_activity -> {
                //intent Explicit (berpindah halaman biasa tanpa membawa data)
                val moveActivity = Intent(this@MainActivity, MoveActivity::class.java)
                startActivity(moveActivity)
            }

            R.id.btn_move_with_data -> {
                //pindah Activity membawa data dengan metode PutExtra
                val moveWithData = Intent(this@MainActivity, MoveWithDataActivity::class.java)
                moveWithData.putExtra(MoveWithDataActivity.EXTRA_NAME, "Sarif")
                moveWithData.putExtra(MoveWithDataActivity.EXTRA_AGE, 23)
                startActivity(moveWithData)
            }

            R.id.btn_move_with_object -> {
                // Pindah Halaman membawa objcet data
                val person = Person(
                    "Sarif",
                    23,
                    "sarifsifa06@gmail.com",
                    "Baubau"
                )
                val moveActivityWithObject = Intent(this@MainActivity, MoveWithDataObjectActivity::class.java)
                moveActivityWithObject.putExtra(MoveWithDataObjectActivity.EXTRA_PERSON, person)
                startActivity(moveActivityWithObject)
            }

            R.id.btn_dial_number -> {
                //Intent Implisit | menampilkan/memakai aplikasi yg dapat menangani aksi telepon
                val phoneNumber ="085256995432"
                val dialPhoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
                startActivity(dialPhoneIntent)
            }

            R.id.btn_move_for_result -> {
                val moveForResult = Intent(this@MainActivity, MoveForResultActivity::class.java)
                resultLauncher.launch(moveForResult)    // Menggunakan objek ActivityResultLaunher untuk berpindah Activity
            }
        }
    }
}