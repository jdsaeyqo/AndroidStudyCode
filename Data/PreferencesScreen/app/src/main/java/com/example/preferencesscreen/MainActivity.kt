package com.example.preferencesscreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val settingFragment = SettingFragment()
    val resultFragment = ResultFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            val tran = supportFragmentManager.beginTransaction()
            tran.replace(R.id.container,settingFragment)
            tran.commit()

        }

        button2.setOnClickListener {
            val tran = supportFragmentManager.beginTransaction()
            tran.replace(R.id.container,resultFragment)
            tran.commit()

        }
    }
}