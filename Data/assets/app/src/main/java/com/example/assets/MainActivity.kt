package com.example.assets

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.io.BufferedReader
import java.io.InputStreamReader

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            val inputStream = assets.open("text/data1.txt")
            val isr = InputStreamReader(inputStream,"UTF-8")
            val br = BufferedReader(isr)

            var str :String? = null
            val sb = StringBuffer()

            do{
                str = br.readLine()
                if(str != null){
                    sb.append("$str\n")

                }
            }while (str!=null)
                br.close()

            textView.text = sb.toString()
        }

        button2.setOnClickListener {
            val inputStream = assets.open("text/data2.txt")
            val isr = InputStreamReader(inputStream,"UTF-8")
            val br = BufferedReader(isr)

            var str :String? = null
            val sb = StringBuffer()

            do{
                str = br.readLine()
                if(str != null){
                    sb.append("$str\n")

                }
            }while (str!=null)
            br.close()

            textView.text = sb.toString()
        }

        button3.setOnClickListener {
            //폰트 객체
            val face = Typeface.createFromAsset(assets,"font/NotoSerifKR-Bold.otf")
            textView.typeface = face
        }
    }
}