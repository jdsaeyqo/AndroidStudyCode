package com.example.relativelayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
/*

RelativeLayout은 Parent나 다른 view와의 관계를 설정하여 배치


배치되는 view들의 주요 속성

parent는 RelativeLayout이 됨.

- layout_alignParentTop : 자신의 상단을 parent의 상단 부분과 일치

- layout_alignParentBottom : 자신의 하단을 parent의 하단 부분과 일치

- layout_alignParentLeft : 자신의 좌측 부분을 parent의 좌측 부분과 일치

- layout_alignParentRight : 자신의 우측 부분을 parent의 우측 부분과 일치

- layout_alignWithParentMissing : 다른 view를 정렬 기준으로 설정하였을 경우 기준으로
                                  설정한 view가 없을 때는 parent를 기준으로 정렬.

- layout_centerHorizontal : 세로 방향의 중앙에 정렬

- layout_centerVertical : 가로 방향의 중앙에 정렬

- layout_centerParent : 가로 세로 모두 중앙에 정렬

layout_alignTop : 자신의 상단 부분을 지정된 view의 상단 부분에 일치

layout_alignBottom : 자신의 하단 부분을 지정된 view의 하단 부분에 일치

layout_alignLeft : 자신의 좌측 부분을 지정된 view의 좌측 부분에 일치

layout_alignRight : 자신의 우측 부분을 지정된 view의 우측 부분에 일치

layout_alignBasement : 자신의 Baseline 부분을 지정된 view의 Baseline 부분에 일치

layout_above : 지정된 view의 상단에 배치

layout_below : 지정된 view 하단에 배치

layout_toRightOf : 지정된 view 우측에 배치

layout_toLeftOf : 지정된 view 좌측에 배치


 */