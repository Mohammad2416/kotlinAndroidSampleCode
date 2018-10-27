package com.rightel.mykotlin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener  {


    lateinit var btnMainOk : Button
    lateinit var edtMain : EditText
    lateinit var textViewMain : TextView
    lateinit var btnNewActivity : Button
    lateinit var btnSeekBarActivity : Button
    lateinit var btnCameraActivity : Button
    lateinit var btnVideoActivity : Button
    lateinit var btnRecyclerActivity : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnMainOk = findViewById(R.id.mainBtn)
        edtMain = findViewById(R.id.main_editText)
        textViewMain = findViewById(R.id.main_txt)
        btnNewActivity = findViewById(R.id.mainBtnNewActivity)
        btnSeekBarActivity = findViewById(R.id.mainBtnSeekBarActivity)
        btnCameraActivity = findViewById(R.id.mainBtnCameraActivity)
        btnVideoActivity = findViewById(R.id.mainBtnVideoActivity)
        btnRecyclerActivity = findViewById(R.id.mainBtnRecyclerViewActivity)

        btnNewActivity.setOnClickListener(this)
        btnMainOk.setOnClickListener(this)
        btnSeekBarActivity.setOnClickListener(this)
        btnCameraActivity.setOnClickListener(this)
        btnVideoActivity.setOnClickListener(this)
        btnRecyclerActivity.setOnClickListener(this)



        edtMain.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                textViewMain.text = s
            }
        })


    }//onCreate

    override fun onClick(v: View?) {

        when (v?.id){
            R.id.mainBtn -> {
                textViewMain.text = edtMain.text
            }

            R.id.mainBtnNewActivity -> {
//                val intent  = Intent(this, ActivityCheckBox::class.java)
//                startActivity(intent)
                startActivity(Intent(this, ActivityCheckBox::class.java))
            }

            R.id.mainBtnSeekBarActivity ->{
                startActivity((Intent(this, SeekBarActivity::class.java)))
            }

            R.id.mainBtnCameraActivity -> {
                startActivity((Intent(this, CameraActivity::class.java)))

            }

            R.id.mainBtnVideoActivity -> {
                startActivity((Intent(this, VideoActivity::class.java)))

            }

            R.id.mainBtnRecyclerViewActivity -> {
                startActivity((Intent(this, RecyclerViewActivity::class.java)))

            }

        }



    }
}
