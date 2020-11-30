package com.example.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    //Activity가 생성될 때 자동으로 호출
    //화면 전환이 발생할 때 자동으로 호출
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        Log.d("test1","onCreate")
    }

    //onCreate  메서드 호출 이후에 자동으로 호출
    //Activity가 정지 상태가 되었다가 활동 상태로 돌아올 때 호출
    override fun onStart() {
            super.onStart()
        Log.d("test1","onStart")

    }
    //onStart 메서드가 호출된 이후에 자동으로 호출
    //Activity 일시 정지되었다가 다시 돌아올 때 호출
    override fun onResume() {
        super.onResume()
        Log.d("test1","onResume")

    }
    //Activity가 정지 상태가 되었다가 활동 상태로 돌아갈 때 onStart전에 호출됨
    override fun onRestart() {
        super.onRestart()
        Log.d("test1","onRestart")

    }
    //Activity가 일시 정지 상태가 될 때 호출
    //화면 상에서 완전히 사라지거나 현재 화면 위에 작은 팝업 창 같은 것이 나타날 때 호출
    override fun onPause() {
        super.onPause()
        Log.d("test1","onPause")

    }
    //Activity가 화면에서 사라질 때 호출
    override fun onStop() {
        super.onStop()
        Log.d("test1","onStop")

    }
    //Activity의 수행이 완전히 종료되어 메모리상에서 제거될 때 호출
    override fun onDestroy() {
        super.onDestroy()
        Log.d("test1","onDestroy")

    }
}

/*
Activity
현재 보이는 화면을 관리하는 실행 단위
애플리케이션을 실행하면 Activity
 */