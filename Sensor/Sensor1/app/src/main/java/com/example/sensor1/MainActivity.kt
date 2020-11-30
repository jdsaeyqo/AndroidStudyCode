package com.example.sensor1

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //단말기의 센서들을 관리하는 객체를 추출
        val manager = getSystemService(SENSOR_SERVICE) as SensorManager

        //센서에서 값을 가져오면 반응하는 리스너
        val listener = object :SensorEventListener{

            //센서로부터 측정된 값이 변경되었을 때 호출
            override fun onSensorChanged(event: SensorEvent?) {
                //센서 타입에 따라 분기
                when(event?.sensor?.type){
                    Sensor.TYPE_LIGHT ->{
                        textView.text = "주변 밝기 : ${event?.values[0]} lux "
                    }
                }
            }
            //센서의 감도가 변경되었을 때 호출
            override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
                //센서 타입에 따라 분기

            }

        }

        button.setOnClickListener {

            //조도 센서 객체 얻어옴
            val sensor = manager.getDefaultSensor(Sensor.TYPE_LIGHT)
            //조도 센서와 리스너 연결
           val chk =  manager.registerListener(listener,sensor,SensorManager.SENSOR_DELAY_UI)
            if(chk == false) {
                textView.text = "조도 센서를 지원하지 않습니다"
            }
        }
        button2.setOnClickListener {
            manager.unregisterListener(listener)
        }

        /*
        나머지 센서들 만드는 방법 같음 이름만 바꿔주면 된다.
        종류 : 공기압 측정 , 근접 센서 , 자이로스코프 센서(단위 시간당 회전한 각도 값을 측정)
             : 가속도 센서, 마그네틱 필드
         */
    }
}