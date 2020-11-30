package com.example.notification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {

            val builder1 = getNotificationBuilder("channel","첫번째 체널")

            //작은 아이콘(메시지 수신 시 상단에 보여줄 작은 아이콘)
            builder1.setSmallIcon(android.R.drawable.ic_menu_search)
            //큰 아이콘 (Bitmap 객체)
            val bitmap = BitmapFactory.decodeResource(resources,R.mipmap.ic_launcher)
            builder1.setLargeIcon(bitmap)
            //숫자 설정
            builder1.setNumber(100)
            //타이틀 설정
            builder1.setContentTitle("Content Title 1 ")
            //텍스트 설정
            builder1.setContentText("Content Text 1 ")

            //메시지 객체를 생성
            val notification = builder1.build()
            //알림 메시지를 관리하는 객체를 추출
            val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            //알림 메시지를 출력 ( id에 따라 별도로 , 같이 출력 가능)
            manager.notify(10,notification)
        }

        button2.setOnClickListener {

            val builder1 = getNotificationBuilder("channel","첫번째 체널")

            //작은 아이콘(메시지 수신 시 상단에 보여줄 작은 아이콘)
            builder1.setSmallIcon(android.R.drawable.ic_menu_search)
            //큰 아이콘 (Bitmap 객체)
            val bitmap = BitmapFactory.decodeResource(resources,R.mipmap.ic_launcher)
            builder1.setLargeIcon(bitmap)
            //숫자 설정
            builder1.setNumber(100)
            //타이틀 설정
            builder1.setContentTitle("Content Title 2 ")
            //텍스트 설정
            builder1.setContentText("Content Text 2 ")

            //메시지 객체를 생성
            val notification = builder1.build()
            //알림 메시지를 관리하는 객체를 추출
            val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            //알림 메시지를 출력
            manager.notify(20,notification)

        }

        button3.setOnClickListener {
            val builder1 = getNotificationBuilder("channel2","두 번째 체널")

            //작은 아이콘(메시지 수신 시 상단에 보여줄 작은 아이콘)
            builder1.setSmallIcon(android.R.drawable.ic_menu_search)
            //큰 아이콘 (Bitmap 객체)
            val bitmap = BitmapFactory.decodeResource(resources,R.mipmap.ic_launcher)
            builder1.setLargeIcon(bitmap)
            //숫자 설정
            builder1.setNumber(100)
            //타이틀 설정
            builder1.setContentTitle("Content Title 3 ")
            //텍스트 설정
            builder1.setContentText("Content Text 3 ")

            //메시지 객체를 생성
            val notification = builder1.build()
            //알림 메시지를 관리하는 객체를 추출
            val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            //알림 메시지를 출력
            manager.notify(30,notification)

        }

        button4.setOnClickListener {
            val builder1 = getNotificationBuilder("channel2","두번째 체널")
            //작은 아이콘(메시지 수신 시 상단에 보여줄 작은 아이콘)
            builder1.setSmallIcon(android.R.drawable.ic_menu_search)
            //큰 아이콘 (Bitmap 객체)
            val bitmap = BitmapFactory.decodeResource(resources,R.mipmap.ic_launcher)
            builder1.setLargeIcon(bitmap)
            //숫자 설정
            builder1.setNumber(100)
            //타이틀 설정
            builder1.setContentTitle("Content Title 4 ")
            //텍스트 설정
            builder1.setContentText("Content Text 4")

            //메시지 객체를 생성
            val notification = builder1.build()
            //알림 메시지를 관리하는 객체를 추출
            val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            //알림 메시지를 출력
            manager.notify(40,notification)
        }
  }

    //안드로이드 8.0 이상과 미만 버전에 대응하기 위해 채널을 설정하는 메서드
    fun getNotificationBuilder(id: String, name:String): NotificationCompat.Builder{

        //os버전 별로 분기
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) { //안드로이드 8.0이상이라면
            //알림 메시지를 관리하는 객체를 추출
            val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            //채널 객체를 생성
            val channel = NotificationChannel(id, name, NotificationManager.IMPORTANCE_HIGH)
            //메시지 출력 시 단말기 LED 사용할 것인가
            channel.enableLights(true)
            //LED색상 설정
            channel.lightColor = Color.RED
            //진동 사용여부
            channel.enableVibration(true)

            //알림 메시지를 관리하는 객체에 채널을 등록한다
            manager.createNotificationChannel(channel)

            val builder = NotificationCompat.Builder(this, id)
            return builder

        }
        else{
           val builder = NotificationCompat.Builder(this)
            return builder

        }
    }
}
/*
Notification의 특징
-사용자가 메시지를 확인하거나 제거하기 전까지 메시지를 유지
- 메시지를 터지하면 지정된 Activity가 실행되어 애플리케이션 실행을 유도할 수 있다.

Notification Channel
- 안드로이드 8.0부터 새롭게 추가된 기능
- 이전에는 Notification Channel을 이용하여 알림 메시지를 채널이라는 그룹으로 묶어
  관리할 수 있으며 사용자는 채널 별로 메시지 활성화 여부를 설정할 수 있다.
  
어플 내 설정메뉴에서 Notification을 채널별로 관리 가능
 */