package com.taingy.quiz_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import java.text.DateFormat
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Date

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rg = findViewById<RadioGroup>(R.id.radio_group)
        val rb1 = findViewById<RadioButton>(R.id.rb_1)
        val rb2 = findViewById<RadioButton>(R.id.rb_2)
        val rb3 = findViewById<RadioButton>(R.id.rb_3)
        val rb4 = findViewById<RadioButton>(R.id.rb_4)
        val cb1 = findViewById<CheckBox>(R.id.cb_1)
        val cb2 = findViewById<CheckBox>(R.id.cb_2)
        val cb3 = findViewById<CheckBox>(R.id.cb_3)
        val cb4 = findViewById<CheckBox>(R.id.cb_4)
        val btSubmit = findViewById<Button>(R.id.bt_submit)
        val btReset = findViewById<Button>(R.id.bt_reset)

        btSubmit.setOnClickListener {
            var score = 0
            if (rb3.isChecked) {
                score += 50
            }
            if (cb1.isChecked && cb2.isChecked && cb3.isChecked && !cb4.isChecked) {
                score += 50
            }

            val date = LocalDateTime.now()
            val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm")
            val formattedDate = date.format(formatter)
            val msg = "Congratulations! You submitted on ${formattedDate}, you achieved ${score}%!"
            showAlertDialog(msg)
        }

        btReset.setOnClickListener {
            rg.clearCheck()
            cb1.isChecked = false
            cb2.isChecked = false
            cb3.isChecked = false
            cb4.isChecked = false
        }
    }

    private fun showAlertDialog(message: String) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Alert")
        builder.setMessage(message)
        builder.setPositiveButton("OK") { dialog, _ ->
            dialog.dismiss()
        }
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }
}