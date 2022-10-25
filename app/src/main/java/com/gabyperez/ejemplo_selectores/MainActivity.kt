package com.gabyperez.ejemplo_selectores

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    private lateinit var fecha: EditText
    private lateinit var hora: EditText
    private lateinit var boton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fecha = findViewById(R.id.fecha)
        hora = findViewById(R.id.hora)
        boton = findViewById(R.id.btnReset)

        fecha.setOnClickListener { showDatePickerDialog() }
        hora.setOnClickListener { showTimePikerDialog() }
        boton.setOnClickListener{ buttonReset() }
    }

    private fun buttonReset() {
        hora.setText("")
        fecha.setText("")
    }

    private fun showTimePikerDialog() {
        val newFragment = TimePickerFragment {onTimeSelected(it)}
        newFragment.show(supportFragmentManager, "timePicker")
    }

    private fun onTimeSelected(time: String) {
        hora.setText(time)
    }

    private fun showDatePickerDialog() {
        val newFragment = DatePickerFragment {day, month, year -> onDateSelected(day, month, year)}
        newFragment.show(supportFragmentManager, "datePicker")
    }

    @SuppressLint("SetTextI18n")
    private fun onDateSelected(day: Int, month: Int, year: Int) {
        fecha.setText("$day/$month/$year")
    }
}