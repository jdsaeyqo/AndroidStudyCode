package com.example.tablelayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
/*
TableLayout : 표를 작성하는 방법으로 view를 배치하는 layout이다.
HTML의 table 태그와 유사.

TableLayout 구조
- TableLayout 안에 TableRow를 배치
- TableRow는 줄 하나를 의미
- TableRow에 view를 배치하면 배치한 view의 개수만큼 칸이 생겨남.

TableLayout 주요 속성
- stretchColumns : TableRow안의 view들이 가로로 늘어날 비율을 설정
위젯 인덱스 번호를 입력하면 해당 인덱스의 view들이 늘어남. 모두 늘리고 싶은 경우 * 입력
- shrinkColumns : TableRow안의 view들이 화면에 보일 수 있도록 줄어들게 함.

TableRow 주요 속성
- layout_column : view가 배치될 위치 설정( 인덱스 통해 가능 )
- layout_span : view가 배치될 칸의 개수를 설정.


 */