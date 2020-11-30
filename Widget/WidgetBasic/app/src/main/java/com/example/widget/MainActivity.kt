package com.example.widget

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
/*
안드로이드 View 중 기능을 갖고 사용자와 상호작용을 하는 것들을 Widget이라고 부른다.
Widget은 Layout 위에 배치되어 화면에 나타나고 코드를 통해 Widget통제하여 사용자와 소통을 하는 수단

사용 패턴
1. 먼저 Layout에 사용하고자 하는 Widget을 배치
2. 이 때, Activity가 실행되면 화면이 구성되고 화면에 배치된 모든 View들은 객체로 생성.
3. 객체로 생성된 View중에 필요한 Widget들의 주소값을 언어와 코드로 이들을 통제
4. 필요에 따라 이벤트에 대한 코드를 구성하여 사용.



 */