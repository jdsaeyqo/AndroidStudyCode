package com.example.imageview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageView3.setImageResource(R.drawable.image)
    }
}
/*
ImageView의 주요 속성
- srcCompat : 보여줄 이미지를 지정. 안드로이드 4버전까지는 src였는데 벡터 방식의 이미지(SVG,PSD)
              등을 처리할 수 있는 기능을 추가하여 srcCompat로 변경

주요 메서드

- setImageResource : res 폴더에 있는 이미지 설정
- setImageBitmap : Bitmap 객체로 만들어진 이미지를 설정
- setImageDrawble : Drawable 객체로 만들어진 이미지를 설정

Drawable  vs  Mipmap

안드로이드에서 이미지를 넣은 drawable폴더이다
안드로이드 버전이 변경되면서 mipmap이라는 폴더를 제공하는데 이 폴더의 이미지는 비트맵이 아닌
벡터 방식으로 이미지 그림
mipmap폴더의 이미지는 런처 아이콘용 이미지를 넣는 폴더를 사용 - 크기가 변경되어도 깨지지 않음.

 */