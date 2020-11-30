package com.example.httpjson

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            thread {
                val site = "http://192.168.123.101:8080/json.jsp"
                val url = URL(site)
                val conn = url.openConnection() as HttpURLConnection

                //문자열 데이터를 읽어온다
                val isr = InputStreamReader(conn.inputStream,"UTF-8")
                val br = BufferedReader(isr)

                var str : String? = null
                val buf = StringBuffer()

                do{
                    str = br.readLine()
                    if(str != null){
                        buf.append(str)
                    }
                }while (str!=null)

                val data = buf.toString()

                //JSON데이터 분석
                runOnUiThread{
                    textView.text = ""

                }
                // JSON 배열 생성
                val root = JSONArray(data)
                //배열의 객체 개수만큼 반복
                for( i in 0 until  root.length()){
                    //i번째 JSON객체를 추출
                    val obj = root.getJSONObject(i)
                    //데이터 추출
                    val data1 = obj.getString("data1")
                    val data2 = obj.getInt("data1")
                    val data3 = obj.getDouble("data1")

                    runOnUiThread {
                        textView.append("data1 : $data1\n")
                        textView.append("data2 : $data2\n")
                        textView.append("data3 : $data3\n")
                    }
                }
            }
       }
    }
}