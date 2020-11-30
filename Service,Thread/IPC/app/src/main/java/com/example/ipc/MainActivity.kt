package com.example.ipc

import android.app.ActivityManager
import android.app.Service
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //접속한 서비스 객체
    var ipcService:TestService? = null

    //서비스 접속을 관리하는 객체
    val connection = object :ServiceConnection{
        //서비스에 접속이 성공했을 때 호출되는 메서드
        //두번째 : 서비스의 onBind 메서드가 반환하는 객체를 받는다
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            //서비스를 추출
            val binder = service as TestService.LocalBinder
            ipcService = binder.getService()
        }
        //서비스 접속을 해제했을 때
        override fun onServiceDisconnected(name: ComponentName?) {
            ipcService = null
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //서비스가 가동중이 아니라면 서비스를 가동한다
        val serviceIntent = Intent(this,TestService::class.java)
        val chk = isServiceRunning("com.example.ipc.TestService")
        if(chk == true){

            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
                startForegroundService(serviceIntent)
            }else{
                startService(serviceIntent)
            }
        }
        //서비스에 접속
        bindService(serviceIntent,connection,Context.BIND_AUTO_CREATE)

        button.setOnClickListener {
            var value = ipcService?.getNumber()
            textView.text = "value : $value"
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        //접속한 서비스에 접속을 햋제한다
        unbindService(connection)
   }

    //서비스 실행 여부를 검사하는 메서드
    fun isServiceRunning(name : String):Boolean{

        val manager = getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        //현재 실행중인 서비스들을 가져온다
        val serviceList = manager.getRunningServices(Int.MAX_VALUE)

        for (serviceinfo in serviceList ){
            //서비스의 이름이 원하는 이름인가
            if(serviceinfo.service.className == name){
                return true
            }
        }
        return false
    }
}
/* IPC
Activity에서 실행 중인 서비스를 제어하거나 데이터를 사용하는 등의 작업이 필요할 때 사용하는 개념

현재 실행중인 서비스에 접속하고 서비스가 가지고 있는 메서드를 호출할 수 있는 개념

이 때, 데이터를 반환 받아 사용할 수 있다
 */