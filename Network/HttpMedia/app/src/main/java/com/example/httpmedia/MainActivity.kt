package com.example.httpmedia

import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.net.HttpURLConnection
import java.net.URL
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            thread {
                val url = URL("http://192.168.123.101:8080/img_android.jpg")
                val conn = url.openConnection() as HttpURLConnection

                val bitmap = BitmapFactory.decodeStream(conn.inputStream)
                runOnUiThread {
                    imageView.setImageBitmap(bitmap)
                }

            }
        }
    }
}