package com.rightel.mykotlin

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import android.widget.ImageView

class CameraActivity : AppCompatActivity() {

    val CAMERA_REQUEST_CODE = 0
    lateinit var img : ImageView
    lateinit var btn : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camera)

        img = findViewById(R.id.activity_camera_img)
        btn = findViewById(R.id.activity_camera_btn)


        btn.setOnClickListener {
            val intentPhoto = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

            if (intentPhoto.resolveActivity(packageManager) != null){
                startActivityForResult(intentPhoto, CAMERA_REQUEST_CODE)
            }
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when(requestCode){

            CAMERA_REQUEST_CODE -> {
                if (resultCode == Activity.RESULT_OK){
                    img.setImageBitmap(data?.extras?.get("data") as Bitmap)
                }
            }
        }

    }
}
