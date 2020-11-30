package com.example.edittext

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.inputmethod.InputMethodManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener{
            textView1.text = edittext1.text

            val imn = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imn.hideSoftInputFromWindow(edittext1.windowToken,0) // 자판 내리기

            edittext1.clearFocus() // 커서 풀기
        }

        edittext1.addTextChangedListener(listen1)

        //엔터키 눌렀을때 이벤트 설정
        edittext1.setOnEditorActionListener{v, actionId, event ->
            textView1.text = "엔터 버튼을 눌렀습니다"
            textView2.text = edittext1.text
            false//true이면 처리는 되고 키보드는 내려가지않음
        }
    }

    val listen1 = object :TextWatcher{
        //문자열이 변경되기 전
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            textView1.text = "Before : $s"
        }
        //문자열 변경 작업이 완료되었을 때
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            textView2.text = "Changed : $s"
        }
        //변경된 문자열이 화면에 반영되었을 때 - 주로 사용
        override fun afterTextChanged(s: Editable?) {
            textView3.text = "after : $s"

        }

    }
}
/*
EditText의 주요 속성
- text : EditText에 표시할 문자열을 설정
- hint : 입력된 값이 없을 경우 표시할 안내 문구를 설정
- inputType : 입력 값에 대해 설정. 표시되는 형식, 나타나는 키보드 등에 영향을 준다
- imeOption : 나타나는 키보드의 Enter 키 모양을 설정

주요 프로퍼티
-text : 사용자가 입력한 문자열값

이벤트
-TextWatcher : 사용자가 입력한 내용을 실시간으로 감시
-EditorAction : 키보드의 Enter 키를 눌렀을 때 발생하는 이벤트
 */