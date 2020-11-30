package com.example.sqlitedatabase1

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class DBHelper : SQLiteOpenHelper {

    constructor(context : Context) : super(context,"Test.db",null,1)
    
    //데이터 베이스 파일이 없을 경우 파일을 만들고 자동으로 호출
    //어플리케이션 설치 후 최초로 접근시 호출
    //최신 형태의 데이블을 생성하는 쿼리문 작성
    override fun onCreate(db: SQLiteDatabase?) {

        Log.d("test","데이터 베이스 생성")

        val sql = """
            create table TestTable
            (idx integer primary key autoincrement,
            textData text not null,
            intData integer not null,
            floatData real not null,
            dateData date not null)
        """.trimIndent()

        db?.execSQL(sql)

    }
    //버전이 변경된 경우 호출
    //기존의 앱을 사용하는 사용자를 위해 테이블의 구조를 최신 형태로 만들어주는 쿼리문을 작성
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

        Log.d("test","onUpgrade $oldVersion -> $newVersion")
        when(oldVersion ){
            1 -> {
                //과거 버전이 1인경우
        }
            2-> {
                //과거 버전이 2인경우
            }
        }
    }
}