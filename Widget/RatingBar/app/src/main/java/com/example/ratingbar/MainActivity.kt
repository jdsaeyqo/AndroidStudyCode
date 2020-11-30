package com.example.ratingbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RatingBar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            textView.text = "Rating : ${ratingBar.rating}\n"
            textView.append("Rating : ${ratingBar2.rating}\n")
            textView.append("Rating : ${ratingBar3.rating}\n")
            textView.append("Rating : ${ratingBar4.rating}\n")

        }

        button2.setOnClickListener {
            ratingBar.rating = 2.5f
            ratingBar2.rating = 1f
            ratingBar3.rating = 3.0f
            ratingBar4.rating = 4.5f
        }

        ratingBar2.setOnRatingBarChangeListener(listener)
        ratingBar3.setOnRatingBarChangeListener(listener)

        ratingBar4.setOnRatingBarChangeListener { ratingBar, rating, fromUser ->
            textView3.text = "Rating 4 : ${rating}\n"

            if(fromUser == true){
                textView3.append("사용자에 의해 설정")
            }else{
                textView3.append("코드를 통해 설정")
            }
        }
    }

    val listener = object : RatingBar.OnRatingBarChangeListener{
        override fun onRatingChanged(ratingBar: RatingBar?, rating: Float, fromUser: Boolean) {
            when(ratingBar?.id){
                R.id.ratingBar2 -> {
                    textView.text = "RatingBar2 : $rating\n"

                    if(fromUser == true){
                        textView.append("사용자에 의해 설정")
                   }else{
                        textView.append("코드를 통해 설정")
                    }
                }


                R.id.ratingBar3 -> {
                    textView2.text = "RatingBar3 : $rating\n"
                    if(fromUser == true){
                        textView2.append("사용자에 의해 설정")
                    }else{
                        textView2.append("코드를 통해 설정")
                    }
                }
            }
        }

    }
}

/*
isIndicator : 별점을 사용자가 조절할 수 있는지 설정. true를 설정하며 사용자는 별 점을 조절 X

주요 프로퍼티

- rating : 별 점을 관리한다.

주요 이벤트
RatingBarChange : 별 점 변경되었을 때
 */