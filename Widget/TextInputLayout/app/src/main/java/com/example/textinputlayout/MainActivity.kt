package com.example.textinputlayout

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

        button1.setOnClickListener {
            textView1.text = textinputlayout1.editText?.text

            textinputlayout1.editText?.clearFocus()

            val imn = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imn.hideSoftInputFromWindow(textinputlayout1.editText?.windowToken, 0)
        }
            textinputlayout1.editText?.addTextChangedListener(listener1)
    }

        val listener1 = object :TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                if (s != null){
                    if(s.length >10 ){
                        textinputlayout1.error = "10글자 이하로 입력해주세요"
                    }else{
                        textinputlayout1.error = null
                    }
                }
            }
        }

}


/*
TextinputLayout
-EditText를 보완한 View이다
-EditText의 속성, 이벤트, 프로퍼티 등을 그대로 사용하며 몇가지 요소가 추가

주요속성
hint : 입력한 내용이 없으면 보여줄 안내 메시지. EditText와 다르게 문자열을 입력하면 상단 부분으로 올라감
countEnabled : 입력한 글자수를 나타냄.
counterMaxLength : 지정한 글자 수를 넘으면 붉은색으로 표시

주요 프로퍼티
editText : TextinputLayout이 가지고 있는 EditText 객체의 주소 값
error : 오류로 표시할 메시지를 설정.
 */