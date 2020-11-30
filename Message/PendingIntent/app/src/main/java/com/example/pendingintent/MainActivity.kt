package com.example.pendingintent

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
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
            val builder1 = getNotificationBuilder("pending","Pending Intent")

            builder1.setSmallIcon(android.R.drawable.ic_menu_search)
            val bitmap = BitmapFactory.decodeResource(resources,R.mipmap.ic_launcher)
            builder1.setLargeIcon(bitmap)
            builder1.setNumber(100)
            builder1.setContentTitle("NO1")
            builder1.setContentText("알림1")


            //메시지를 터치하면 자동으로 메시지 제거
            builder1.setAutoCancel(true)

            val notification = builder1.build()
            val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.notify(10,notification)



            //메시지를 터치하면 실행할 Activity를 관리할 Intent 생성
            val intent1 = Intent(this,NotificationActivity1::class.java)
            intent1.putExtra("data1",100)
            intent1.putExtra("data2",200)

            val pending1 = PendingIntent.getActivity(this, 10, intent1,PendingIntent.FLAG_UPDATE_CURRENT)
            builder1.setContentIntent(pending1)




        }

        button2.setOnClickListener {
            val builder1 = getNotificationBuilder("pending","Pending Intent")
            builder1.setContentTitle("NO2")
            builder1.setContentText("알림2")
            builder1.setSmallIcon(android.R.drawable.ic_menu_search)
            val bitmap = BitmapFactory.decodeResource(resources,R.mipmap.ic_launcher)
            builder1.setLargeIcon(bitmap)

            //메시지를 터치하면 실행할 Activity를 관리할 Intent 생성
            val intent1 = Intent(this,NotificationActivity2::class.java)

            val pending1 = PendingIntent.getActivity(this, 10, intent1,PendingIntent.FLAG_UPDATE_CURRENT)
            builder1.setContentIntent(pending1)

            //Action설정
            val intent2 = Intent(this,NotificationActivity4::class.java)
            val pending2 = PendingIntent.getActivity(this,100,intent2,PendingIntent.FLAG_UPDATE_CURRENT)
            val builder2 = NotificationCompat.Action.Builder(android.R.drawable.ic_menu_compass,"act1",pending2)
            val action2 = builder2.build()
            builder1.addAction(action2)

            val intent3 = Intent(this,NotificationActivity5::class.java)
            val pending3 = PendingIntent.getActivity(this,100,intent3,PendingIntent.FLAG_UPDATE_CURRENT)
            val builder3 = NotificationCompat.Action.Builder(android.R.drawable.ic_menu_agenda,"act1",pending3)
            val action3 = builder3.build()
            builder1.addAction(action3)



            val notification = builder1.build()
            val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.notify(20,notification)

        }

        }



    fun getNotificationBuilder(id: String, name:String): NotificationCompat.Builder{

        //os버전 별로 분기
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) { //안드로이드 8.0이상이라면
            //알림 메시지를 관리하는 객체를 추출
            val manager = getSystemService(NOTIFICATION_SERVICE)as NotificationManager
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
Action
- 알림 메시지에 Button과 같은 것을 배치하여 이를 눌렀을 때 지정된 Activity를 실행할 수 있다
- 안드로이드 4.0까지는 메시지당 하나의 Activity만 실행이 가능했지만 4.1이후로 Action이 제공되어
  하나의 메시지에서 여러 Activity를 선택적으로 실행할 수 있게 되었다
 */