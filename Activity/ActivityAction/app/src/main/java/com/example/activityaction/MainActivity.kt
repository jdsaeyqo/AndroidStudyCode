package com.example.activityaction

import android.Manifest
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    val permissionList = arrayOf(
            Manifest.permission.CALL_PHONE
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        requestPermissions(permissionList,0)

        button.setOnClickListener {
            val uri = Uri.parse("geo:37.243243,131.861601") //geo는 위도 경도
            val intent = Intent(Intent.ACTION_VIEW,uri)

            startActivity(intent)
        }

        button2.setOnClickListener {
            val uri = Uri.parse("http://developer.android.com")
            val intent = Intent(Intent.ACTION_VIEW, uri)

            startActivity(intent)
        }


        button3.setOnClickListener {
            val uri = Uri.parse("tel:12341234")
            val intent = Intent(Intent.ACTION_DIAL,uri)
            startActivity(intent)
        }

        button4.setOnClickListener {     //전화 거는 기능은 허가 받아야 함
            val uri = Uri.parse("tel:12341234")
            val intent = Intent(Intent.ACTION_CALL,uri)
            startActivity(intent)
        }
    }
}