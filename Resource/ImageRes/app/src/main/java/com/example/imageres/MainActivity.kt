package com.example.imageres

import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        imageView2.setImageResource(R.drawable.img_android)

        //Bitmap : JPG, PNG, GIF 파일로 부터 얻어온 이미지 데이터를 관리
        val bitmap = BitmapFactory.decodeResource(resources, R.drawable.img_android)
        imageView3.setImageBitmap(bitmap)

        //Drawabel : Bitmap을 포함한 다양한 타입으로부터 이미지 데이터를 관리
        val drawable = getDrawable(R.drawable.img_android)
        imageView4.setImageDrawable(drawable)

        //배경 타일 이미지를 생성 - 코드 방법
//        container.setBackgroundResource(R.drawable.tile)

        //xml 등 비트맵 아닐시 drawable로 받아서 써야함함
        val drawable2 = getDrawable(R.drawable.tile)
        container.background = drawable2

        //layer이미지를 사용한다다
        val drawable3 = getDrawable(R.drawable.layer)
        imageView4.setImageDrawable(drawable3)

        //상태 이미지를 사용
         val drawable4 = getDrawable(R.drawable.btn_image)
        button.background = drawable4
    }

}
/*
drawable 과 mipmap


현재 안드로이드는 이미지를 넣는 폴더로 drawable과 mipmap을 제공한다

mipmap은 애플리케이션의 아이콘으로 사용할 이미지를 넣는 곳이고 drawable은 애플리케이션
내에서 사용할 이미지를 넣은 곳이다

 */