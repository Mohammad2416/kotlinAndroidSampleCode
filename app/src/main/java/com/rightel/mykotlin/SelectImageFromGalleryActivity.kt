package com.rightel.mykotlin

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_select_image_from_gallery.*
import org.jetbrains.anko.toast
import java.io.InputStream

class SelectImageFromGalleryActivity : AppCompatActivity() {

    val REQUEST_IMAGE_FROM_GALLERY = 3
    val REQUEST_IMAGE_PERMISSION = 4

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_image_from_gallery)

        activity_select_image_imgview.setOnClickListener{
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE), REQUEST_IMAGE_PERMISSION)
            }
        }

    }//onCreate

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        when(requestCode){
            REQUEST_IMAGE_PERMISSION -> {
                if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    getImageFromGallary()

                }else{
                    toast("Permission is denied!")
                }
            }
        }
    }

    private fun getImageFromGallary() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        if (intent.resolveActivity(packageManager) != null){
            startActivityForResult(Intent.createChooser(intent, "select Image"), REQUEST_IMAGE_FROM_GALLERY)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when(requestCode){
            REQUEST_IMAGE_FROM_GALLERY -> {
                if (resultCode == Activity.RESULT_OK){
                    setImageToView(data)
                }
            }
        }

    }

    private fun setImageToView(data: Intent?) {
      val filePath : Uri = data?.data!!
        val inputStrem : InputStream = contentResolver.openInputStream(filePath)!!
        val bitmap : Bitmap = BitmapFactory.decodeStream(inputStrem)

        activity_select_image_imgview.setImageBitmap(bitmap)
    }

}
