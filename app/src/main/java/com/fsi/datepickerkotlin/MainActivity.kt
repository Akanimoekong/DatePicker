package com.fsi.datepickerkotlin

import android.app.DatePickerDialog
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<EditText>(R.id.date_fromEdt)


        val button2 = findViewById<EditText>(R.id.date_toEdt)
        val textViewFrom = findViewById<TextView>(R.id.date_from)
        val textViewTo = findViewById<TextView>(R.id.date_to)

        button.setOnClickListener {
            showDatePicker { year, monthOfYear, day ->
                Log.i(TAG, "$year $monthOfYear $day")
            }
        }

        button2.setOnClickListener {
            showDatePicker { year, monthOfYear, day ->
                Log.i(TAG, "$year $monthOfYear $day")
            }
        }
    }

    private fun showDatePicker(onDateSelected: (year: Int, monthOfYear: Int, day: Int) -> Unit) {
        val calendar: Calendar = Calendar.getInstance()
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        val currentMonth = calendar.get(Calendar.MONTH)
        val currentYear = calendar.get(Calendar.YEAR)
        DatePickerDialog(this, { _, year, monthOfYear, dayOfMonth ->
            onDateSelected.invoke(year, monthOfYear, dayOfMonth)

        }, currentYear, currentMonth, day).show()
    }
}