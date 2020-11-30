package com.example.preferences

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            //Preferences 객체 추출
            val pref = getSharedPreferences("data",Context.MODE_PRIVATE)

            //데이터 저장을 위한 객체를 추출한다
            val editor = pref.edit()

            editor.putBoolean("data1",true)
            editor.putFloat("data2",11.1f)
            editor.putInt("data3",100)
            editor.putLong("data4",10000L)
            editor.putString("data5","데이터 문자열")

            val set = HashSet<String>()
            set.add("문자열1")
            set.add("문자열2")
            set.add("문자열3")
            editor.putStringSet("data6",set)
            
            editor.commit()
            
            textView.text =  "저장 완료"
        }

        button2.setOnClickListener {
            val pref = getSharedPreferences("data",Context.MODE_PRIVATE)

            //저장된 데이터 가져옴
            val data1 = pref.getBoolean("data1",false)
            val data2 = pref.getFloat("data2",0.0f)
            val data3 = pref.getInt("data3",0)
            val data4 = pref.getLong("data4",0L)
            val data5 = pref.getString("data5","초기값")
            val data6 = pref.getStringSet("data6",null)

            textView.text = " data1 = $data1\n"
            textView.append("data2 = $data2\n")
            textView.append("data2 = $data3\n")
            textView.append("data2 = $data4\n")
            textView.append("data2 = $data5\n")

            for (str in data6!! ){
                textView.append("data6 = $data6")
            }
        }
    }
}

/*
기본 설정 시에 사용 가능함
 */