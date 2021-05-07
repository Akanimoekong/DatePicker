package com.fsi.datepickerkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.DatePicker
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.*
class MainActivity : AppCompatActivity(), DatePickerDialog.OnDateSetListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val calendar: Calendar = Calendar.getInstance()

        val button = findViewById<EditText>(R.id.date_fromEdt)
        val dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH)
        val month = calendar.get(Calendar.MONTH)
        val year = calendar.get(Calendar.YEAR)

        val button2 = findViewById<EditText>(R.id.date_toEdt)
        val dayOfMonth2 = calendar.get(Calendar.DAY_OF_MONTH)
        val month2 = calendar.get(Calendar.MONTH)
        val year2 = calendar.get(Calendar.YEAR)

        button.setOnClickListener {
            val datePickerDialog =
                DatePickerDialog(this, this, year, month, dayOfMonth)
            datePickerDialog.show()
        }

        button2.setOnClickListener {
            val datePickerDialog =
                DatePickerDialog(this, this, year2, month2, dayOfMonth2)
            datePickerDialog.show()
        }
    }
    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        val textView = findViewById<TextView>(R.id.date_from)
        val myDay = dayOfMonth
        val myYear = year
        val myMonth = month +1
        textView.text = "Year: $myYear \n Month: $myMonth  \n Day: $myDay"

        val textView2 = findViewById<TextView>(R.id.date_to)
//        val myDay2 = dayOfMonth2
//        val myYear2 = year2
//        val myMonth2 = month2 +1
//        textView2.text = "Year: $myYear2 \n Month: $myMonth2  \n Day: $myDay2"
    }
}