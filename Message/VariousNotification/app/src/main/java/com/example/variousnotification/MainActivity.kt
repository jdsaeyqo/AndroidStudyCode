package com.example.variousnotification

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
            val builder1 = getNotificationBuilder("style","style Notification")
            builder1.setContentTitle("BigPicture")
            builder1.setContentText("Big Picture Notification")
            builder1.setSmallIcon(android.R.drawable.ic_menu_camera)




            //BigPicture Notification 객체를 생성
            val big = NotificationCompat.BigPictureStyle(builder1)
            //보여줄 이미지를 설정
            val bitmap = BitmapFactory.decodeResource(resources, R.drawable.image)
            big.bigPicture(bitmap)
            big.setBigContentTitle("Big Content Title")
            big.setSummaryText("Summary Text")

            val notification = builder1.build()
            val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.notify(10,notification)

        }

        button2.setOnClickListener {
            val builder1 = getNotificationBuilder("style","style Notification")
            builder1.setContentTitle("BigText")
            builder1.setContentText("Big Text Notification")
            builder1.setSmallIcon(android.R.drawable.ic_menu_camera)




          //Big Text
            val big = NotificationCompat.BigTextStyle(builder1)
            big.setSummaryText("Summaty Text")
            big.setBigContentTitle("Summary Title")
            big.bigText("동해물과 백두산이 마르고 닳도록 하느님이 보우하사 우리 나라만세")


            val notification = builder1.build()
            val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.notify(20,notification)

        }

        button3.setOnClickListener {
            val builder1 = getNotificationBuilder("style","style Notification")
            builder1.setContentTitle("InBox")
            builder1.setContentText("InBox")
            builder1.setSmallIcon(android.R.drawable.ic_menu_camera)

            //InBox
            val inbox = NotificationCompat.InboxStyle(builder1)
            inbox.setSummaryText("Summary Text")

            inbox.addLine("ccccccccccccccccccccccccccccccccccccccccccccc")
            inbox.addLine("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")
            inbox.addLine("ddddddddddddddddddddddddddddddddddddddddddddd")
            inbox.addLine("ppppppppppppppppppppppppppppppppppppppppppppp")
            inbox.addLine("uuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu")



            val notification = builder1.build()
            val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.notify(30,notification)

        }


    }
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
Big Picture Style
- 메시지를 펼쳤을 때 이미지를 표시할 수 있다.

Big Text Style
- 장문을 표시할수 있다.

InBox Style
- 메시지를 펼폈을 때 문자열들을 표시

 */