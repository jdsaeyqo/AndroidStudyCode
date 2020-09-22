package com.example.gridlayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}

/*
GridLayout : Grid를 설정하여 View를 배치하는 layout
           : TableLayout을 보완하기 위해 제공되는 Layout
           : Legacy에 포함되있음.

주요 속성
-rowCount : 그리드 레이아웃의 줄의 개수
-columnCount : 그리드 레이아웃의 칸의 개수

배치되는 View의 속성

-layout_column : View가 배치될 칸이 위치(0부터 시작)

-layout_row : View가 배치될 줄의 위치(0부터 시작)

-layout_columnSpan : View가 차지할 칸의 수

-layout_rowSpan : View가 차지할 줄의 수

-layout_columnWeight : 남은 공간을 차지할 가로 비율

-layout_columnHeight : 남은 공간을 차지할 세로 비율



 */