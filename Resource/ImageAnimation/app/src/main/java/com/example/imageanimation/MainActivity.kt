package com.example.imageanimation

import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        imageView.setImageResource(R.drawable.ani_data)

//        val drawable = getDrawable(R.drawable.ani_data)
//        imageView.setImageDrawable(drawable)

        //애니메이션 객체 추출
        val ani = imageView.drawable as AnimationDrawable

        button.setOnClickListener {
            ani.start()
        }

        button2.setOnClickListener {
            ani.stop()
        }
    }

}