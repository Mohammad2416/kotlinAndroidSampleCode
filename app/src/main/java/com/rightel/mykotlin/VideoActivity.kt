package com.rightel.mykotlin

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import kotlinx.android.synthetic.main.activity_video.*
import org.jetbrains.anko.toast

class VideoActivity : AppCompatActivity() {

    private val REQUEST_CODE_VIDEO = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video)

        activity_video_btn.setOnClickListener {
            callVideo()
        }

    }

    fun callVideo(){
        val videoIntent = Intent(MediaStore.ACTION_VIDEO_CAPTURE)
        if(videoIntent.resolveActivity(packageManager) != null){
            startActivityForResult(videoIntent, REQUEST_CODE_VIDEO)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when(requestCode){
            REQUEST_CODE_VIDEO -> {
                if (resultCode == Activity.RESULT_OK && data != null){
                    activity_video_view.setVideoURI(data.data)
                    activity_video_view.start()

                }
            }else -> {
            //ANKO ::> https://github.com/Kotlin/anko
            toast("The video data is not existed")
        }

        }
    }
}
