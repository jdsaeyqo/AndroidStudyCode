package com.example.snackbar

import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.custom_snackbar.view.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
//        val snack1 = Snackbar.make(it,"기본 스낵바",Snackbar.LENGTH_SHORT)
        val snack1 = Snackbar.make(it,"기본 스낵바",Snackbar.LENGTH_INDEFINITE) //액션 선택하면 사라짐
            snack1.setTextColor(Color.RED)
            snack1.setBackgroundTint(Color.BLUE)
            snack1.animationMode = Snackbar.ANIMATION_MODE_FADE

            val callback = object : BaseTransientBottomBar.BaseCallback<Snackbar>(){
                override fun onShown(transientBottomBar: Snackbar?) {
                    super.onShown(transientBottomBar)
                    textView2.text = "스낵바가 나타났습니다"
                }

                override fun onDismissed(transientBottomBar: Snackbar?, event: Int) {
                    super.onDismissed(transientBottomBar, event)
                    textView2.text = "스낵바가 사라졌습니다"
                }
            }

            snack1.addCallback(callback)

            snack1.setAction("action1"){
                textView.text = "Action Click"
            }
            snack1.show()

        }

        button2.setOnClickListener {
            //스낵바를 만들어줌
            val snack2 = Snackbar.make(it,"CustomSnackBar",Snackbar.LENGTH_SHORT)
            //스낵바를 통해 보여줄 뷰 생성
            val snackView = layoutInflater.inflate(R.layout.custom_snackbar,null)

            snackView.run {
                imageView.setImageResource(R.drawable.img_android)
                textView3.text = "새로 추가된 View"
                textView3.setTextColor(Color.WHITE)
            }
            //스낵바 레이아웃을 추출해서 새로운 뷰를 추가
            val snackbarLayout = snack2.view as Snackbar.SnackbarLayout
            snackbarLayout.addView(snackView)
            //스낵바에 있는 TextView를 추출해 이를 보이지않게 처리한다.
            val snackText = snackbarLayout.findViewById<TextView>(com.google.android.material.R.id.snackbar_text)
            snackText.visibility = View.INVISIBLE




            snack2.show()
        }

    }
}
/*
SnackBar

Toast의 업그레이드 버전이라고 불리기도 하는 메시징 도구
Activity 위에 표시되며 하단에 나타나는 메시지
안드로이드 11버전부터 기본 Toast는 계속 사용 가능하고 커스터마이징 부분은 SnackBar를 이용하는 것 권장

기본 SnackBar 구성
-file -> Project Structure -> Dependencies -> + ->Library dependency -> com.google.android.material검색 후 추가해야함

- SnackBar.make 메서드를 통해 SnackBar를 구성하고 show메서드로 표시하면 된다
- setTextColor : 표시되는 메시지의 색상을 설정
- setBackgroundTint : 배경 색상을 지정
- animationMode : 나타나고 사라지는 애니메이션을 설정
- setAction : 클릭하면 이벤트를 처리할 수 있는 요소를 설정

Toast대신 사용하는 것을 권장
액티비티에 관련된 메시지에는 스낵바
서비스 등에는 Toast사용

 */