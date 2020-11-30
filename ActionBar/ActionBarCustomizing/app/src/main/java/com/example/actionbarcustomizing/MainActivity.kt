package com.example.actionbarcustomizing

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

import kotlinx.android.synthetic.main.custom_actionbar.view.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.setDisplayShowCustomEnabled(true)


        //버전에 따라 적용 못할 수 있기 때문에 쓰는게 좋음
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
        supportActionBar?.setDisplayShowHomeEnabled(false)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        //layout을 통해 View를 생성
        val topBar = layoutInflater.inflate(R.layout.custom_actionbar,null)
        supportActionBar?.customView = topBar

        topBar.run {
            textView2.text = "커스텀 액션바"
            textView2.setTextColor(Color.WHITE)

            button.setOnClickListener {
                textView.text = "액션바의 버튼을 눌렀습니다"
            }
        }
    }
}

//액션바를 커스터마이징 하기 위해서는 기존의 액션바를 사라지게 해야한다.