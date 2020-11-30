package com.example.ipc

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Binder
import android.os.Build
import android.os.IBinder
import android.os.SystemClock
import android.util.Log
import androidx.core.app.NotificationCompat
import kotlin.concurrent.thread

class TestService : Service() {

    var value = 0
    var isRunning = false
    var binder = LocalBinder()

    //외부에서 서비스에 접속하면 호출되는 메서드
    override fun onBind(intent: Intent): IBinder {
        return binder
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        Log.d("test","서비스가 가동")

        //안드로이드 8.0이상 부터..
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            val channel = NotificationChannel("service","service", NotificationManager.IMPORTANCE_HIGH)
            channel.enableLights(true)
            channel.lightColor = Color.RED
            channel.enableVibration(true)
            manager.createNotificationChannel(channel)

            val builder = NotificationCompat.Builder(this,"service")
            builder.setSmallIcon(android.R.drawable.ic_menu_search)
            builder.setContentTitle("서비스 가동")
            builder.setContentText("서비스가 가동중입니다")
            val notification = builder.build()

            //알림 메시지를 Foreground 서비스를 위해 표시한다
            startForeground(10,notification)
        }

        isRunning = true

        thread {
            while (isRunning)
            {
                SystemClock.sleep(500)

                Log.d("test","Value : $value")
                value++
            }
        }


        return super.onStartCommand(intent, flags, startId)
    }
    //서비스가 중지되고 소멸될 때 호출되는 메서드
    override fun onDestroy() {
        super.onDestroy()
        isRunning = false

    }

    //변수의 값을 반환하는 메서드
    fun getNumber() : Int{
        return value
    }

    //접속하는 Activity에서 서비스를 추출하기 위해 사용하는 객체
    inner class LocalBinder : Binder(){
        fun getService() : TestService{
            return this@TestService
        }
    }
}


