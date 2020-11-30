package com.example.sqlitedatabase1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       button.setOnClickListener {
           val helper = DBHelper(this)

           val sql = """
               insert into TestTable(textData, intData, floatData, dateData)
               values(?, ?, ?, ?)
           """.trimIndent()

           //?에 바인딩될 값
           val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
           val now = sdf.format(Date())

           val arg1 = arrayOf("문자열1","100","11.11",now)
           val arg2 = arrayOf("문자열2","200","22.22",now)

           //저장
           helper.writableDatabase.execSQL(sql,arg1)
           helper.writableDatabase.execSQL(sql,arg2)

           helper.close()
           
           textView.text = "저장 완료"

       }

        button2.setOnClickListener {
            val helper = DBHelper(this)

            val sql = "select * from TestTable"

            //쿼리 실행
            val c1 = helper.writableDatabase.rawQuery(sql,null)
            textView.text = ""

           while (c1.moveToNext()) {
               // 가져올 컬럼의 인덱스 번호를 추출
               val idx1 = c1.getColumnIndex("idx")
               val idx2 = c1.getColumnIndex("textData")
               val idx3 = c1.getColumnIndex("intData")
               val idx4 = c1.getColumnIndex("floatData")
               val idx5 = c1.getColumnIndex("dateData")

               //데이터를 추출
               val idx = c1.getInt(idx1)
               val textData = c1.getString(idx2)
               val intData = c1.getInt(idx3)
               val floatData = c1.getDouble(idx4)
               val dataData = c1.getString(idx5)

               textView.append("idx : $idx\n")
               textView.append("textData : $textData\n")
               textView.append("intData : $intData\n")
               textView.append("dateData : $dataData\n\n ")
           }

            helper.writableDatabase.close()
        }

        button3.setOnClickListener {
            val helper = DBHelper(this)

            val sql = "update TestTable set textData = ? where idx = ?"
            val arg1 = arrayOf("문자열3","1")

            helper.writableDatabase.execSQL(sql,arg1)
            helper.writableDatabase.close()
            
            textView.text = "수정 완료"
        }

        button4.setOnClickListener {
            val helper = DBHelper(this)

            val sql = "delete from TestTable where idx = ?"
            val arg1 = arrayOf("1")

            helper.writableDatabase.execSQL(sql,arg1)
            helper.writableDatabase.close()

            textView.text = "삭제 완료"
        }

    }
}

/*
작성 방식
1. 쿼리문 이용  - 일반적인 SQL문을 사용하며 MySQL과 유사한 문법을 사용한다
2. 클래스 이용 - 클래스를 이용하는 방법은 개발자가 정해줘야 하는 몇가지 정보를 제공하면 쿼리문이
                 생성되고 실행되는 구조

 */