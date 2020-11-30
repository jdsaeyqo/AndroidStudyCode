package com.example.dialog

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.DatePicker
import android.widget.TimePicker
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.custom_dialog.view.*
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            var builder = AlertDialog.Builder(this)

            builder.setTitle("기본 다이얼로그")
            builder.setMessage("기본 다이얼로그 입니다")
            builder.setIcon(R.mipmap.ic_launcher)

            //버튼 위치 설정, 리스너 설정
            builder.setPositiveButton("Positive"){it,i ->
                textView.text = "Positive 버튼을 눌렀습니다"
            }
            builder.setNeutralButton("Neutral"){it,i ->
                textView.text = "Neutral 버튼을 눌렀습니다"

            }
            builder.setNegativeButton("Negative"){it ,i  ->
                textView.text = "Negative버튼을 눌렀습니다"
            }

            builder.show()
        }

        button2.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("커스텀 다이얼로그")
            builder.setIcon(R.mipmap.ic_launcher)

            val custom_view = layoutInflater.inflate(R.layout.custom_dialog,null)
            builder.setView(custom_view)

            builder.setPositiveButton("확인"){it,i->
                custom_view.run {
                    textView.text = "${cus_edit1.text}\n"
                    textView.append("${cus_edit2.text}")
                }

            }

            builder.setNegativeButton("취소",null)

            builder.show()
        }

        button3.setOnClickListener {
            val calander = Calendar.getInstance()

            val year = calander.get(Calendar.YEAR)
            val month = calander.get(Calendar.MONTH)
            val day = calander.get(Calendar.DAY_OF_MONTH)

            val listener1 = DatePickerDialog.OnDateSetListener{view: DatePicker?, year: Int, month: Int, dayOfMonth: Int ->
                textView.text = "$year 년 ${month+1} 월 $day 일"

            }

            val picker = DatePickerDialog(this,listener1,year,month,day)

            picker.show()
        }

        button4.setOnClickListener {
            val calendar = Calendar.getInstance()

            val hour = calendar.get(Calendar.HOUR_OF_DAY)
            val minute = calendar.get(Calendar.MINUTE)

            val listener2 = TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
                textView.text = "$hourOfDay 시 $minute  분"
            }
            //true는 24시간제 false는 12시간제

           val picker = TimePickerDialog(this,listener2,hour,minute,true)

            picker.show()
        }

    }
}
/*
기본 다이얼로그
메시지와 최대 3개의 버튼 제공 가능

커스텀 다이얼로그
기본 다이얼로그에 View를 설정하면 다이얼로그에 표시되는 모양을 자유롭게 구성할 수 있다.

DatePicker / TimePicker
 */