package com.example.sensorlist

import android.hardware.Sensor
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //센서를 관리하는 매니저를 추출
        val manager = getSystemService(SENSOR_SERVICE)as SensorManager

        //단말기에 있는 센서 리스트를 가져온다
        val sensor_list = manager.getSensorList(Sensor.TYPE_ALL)

        //센서 수 만큼 반복
        for ( sensor in sensor_list){
            textView.append("센서 이름 : ${sensor.name}\n")
            textView.append("센서 종류 : ${sensor.type}\n")
        }
    }
}