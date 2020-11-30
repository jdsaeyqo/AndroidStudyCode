package com.example.httpnetwork

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
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
                //접속할 주소
                val site = "http://192.168.123.101:8080/basic.jsp"
                val url = URL(site)

                //접속
                val conn = url.openConnection() as HttpURLConnection
                val isr = InputStreamReader(conn.inputStream,"UTF-8")
                val br = BufferedReader(isr)

                var str:String? = null
                val buf = StringBuffer()

                do{
                    str = br.readLine()
                    if(str != null){
                        buf.append("$str\n")
                    }
                }while (str != null)

                runOnUiThread{
                    textView.text = buf.toString()

                }

            }
        }
    }
}