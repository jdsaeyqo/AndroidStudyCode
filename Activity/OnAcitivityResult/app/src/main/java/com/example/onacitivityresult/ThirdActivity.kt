package com.example.onacitivityresult

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_third.*

class ThirdActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        button3.setOnClickListener {
            setResult(RESULT_OK)
            finish()
        }

        button5.setOnClickListener {
            setResult(RESULT_CANCELED)
            finish()
        }

        //그 외 상황들
       button6.setOnClickListener {
            setResult(RESULT_FIRST_USER)
            finish()
        }
        button7.setOnClickListener {
            setResult(RESULT_FIRST_USER + 1)
            finish()
        }
    }
}