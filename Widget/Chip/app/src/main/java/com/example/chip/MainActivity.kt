package com.example.chip

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        chip1.setOnClickListener {
            textView.text = "첫 번째 Chip를 클릭하였습니다\n"

            if(chip2.isChecked == true){
                textView.append("두 번째 Chip이 선택되었습니다.\n")
            }else{
                textView.append("두 번째 Chip이 선택되어 있지 않습니다.\n")
            }

            if (chip3.isChecked == true ){
                textView.append("세 번째 Chip이 선택되었습니다.\n")
            }else{
                 textView.append("세 번째 CHip이 선택되어 있지 않습니다\n")
            }
            if(chip4.isChecked == true){
                textView.append("네 번째 Chip이 선택되었습니다.\n")
            }else{
                textView.append("네 번째 Chip이 선택되어 있지 않습니다.\n")
            }

            when ( chipGroup1.checkedChipId){
                R.id.chip5 -> {
                    textView.append("그룹 내의 첫 번째 Chip이 선택되어 있습니다\n")
                }
                R.id.chip6 -> {
                    textView.append("그룹 내의 두 번째 Chip이 선택되어 있습니다\n")
                }
                R.id.chip7 -> {
                    textView.append("그룹 내의 세 번째 Chip이 선택되어 있습니다\n")
                }

            }
        }

        chip3.setOnCloseIconClickListener{
            textView.text = "닫기 버튼을 눌렀습니다"
        }

        chip4.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked){
                textView.text = "네 번째 Chip이 체크되었습니다"
            }else{
                textView.text = "네 번째 Chip이 해제되었습니다."
            }
        }
            
        




    }
}
/*
Chip
- 버튼, 체크박스, 라디오 등의 기능을 가지고 있는 새로운 UI 요소 이다.
- ChipGroup을 통해 RadioButton 처럼 구성할 수 있다.

주요 속성
-Theme : 테마를 설정. 필수
-Style : Chip의 스타일을 설정
-Checkable : 체크 가능 여부를 설정
-Text : Chip에 표시할 문자열을 설정
-chipIcon : Chip에 표시할 아이콘을 설정
-chipIconVisiable : Chip 아이콘을 보여줄 것인가를 설정
-checkedIcon : 선택되었을 때의 아이콘을 설정
-checkedIconVisiable : 선택되었을 때의 아이콘을 보여줄 것인가를 설정

주요 이벤트
-checkedChange : 체크 상태가 변경되었을 때
-CloseIconClick : 닫기 버튼을 눌렀을 때

ChipGroup의 주요 속성
- singleSelection : 내부의 Chip 중 하나만 선택되게 할 것인가를 설정
- checkedChip : 최초에 선택되어 있을 Chip을 설정
 */