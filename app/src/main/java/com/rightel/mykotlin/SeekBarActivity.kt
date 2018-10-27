package com.rightel.mykotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast

class SeekBarActivity : AppCompatActivity() {

    lateinit var seekBar: SeekBar
    lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seek_bar)


        seekBar = findViewById(R.id.activity_seek_seek)
        textView = findViewById(R.id.activity_seek_textView)

        seekBar.progress = 20


        showAlert()

        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                textView.text = progress.toString()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                textView.text = seekBar?.progress.toString()
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                textView.text = "selected: " + seekBar?.progress.toString()

            }

        })
    }


    private fun showAlert(){
             AlertDialog.Builder(this)
                .setTitle("Alert")
                .setMessage("Message")
//               .setNegativeButton("", DialogInterface.OnClickListener { dialog, which ->
                .setNegativeButton("CANCEL") { dialog, _ ->
                    dialog.dismiss()
                }

                .setPositiveButton("ok") {dialog, which ->
                   Toast.makeText(this, "ok", Toast.LENGTH_LONG).show()
                }

                .create()
                .show()
    }
}
