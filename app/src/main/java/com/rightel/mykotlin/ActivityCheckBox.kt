package com.rightel.mykotlin

import android.app.Activity
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.widget.CheckBox
import android.widget.Toast

class ActivityCheckBox : AppCompatActivity() {


    lateinit var checkBoxOne: CheckBox
    lateinit var checkBoxTwo: CheckBox


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check_box)

        checkBoxOne = findViewById(R.id.checkboxOne)
        checkBoxTwo = findViewById(R.id.checkboxTwo)

        checkBoxOne.setOnCheckedChangeListener { buttonView, isChecked ->
            Toast.makeText(this, isChecked.toString(), Toast.LENGTH_LONG).show()
        }

        checkBoxTwo.setOnCheckedChangeListener { buttonView, isChecked ->
            toast("Check", Toast.LENGTH_LONG)
        }

    }


    fun Activity.toast(message: String, duration: Int) {
        Toast.makeText(this, message, duration).show()
    }
}
