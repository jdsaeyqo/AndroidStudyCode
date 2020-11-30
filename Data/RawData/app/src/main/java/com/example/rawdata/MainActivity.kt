package com.example.rawdata

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

            val inputStream = resources.openRawResource(R.raw.data1)
            val isr = InputStreamReader(inputStream,"UTF-8")
            val br = BufferedReader(isr)

            var str:String? = null
            val sb = StringBuffer()

            do{
                str = br.readLine()

                if(str!=null){
                    sb.append("$str\n")
                }
            }while (str != null)
            br.close()

            textView.text = sb.toString()
        }
    }
}