package com.example.fragmentview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_sub.*

class SubFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_sub,null)

        // 내부의 View들의 주소값을 가져온다
//        val text1 = view.findViewById<TextView>(R.id.fragtext1)
//        val btn1 = view.findViewById<Button>(R.id.fragbtn1)
//
//        btn1.setOnClickListener {
//            text1.text = "Fragment 문자열"
//        }
        
       

        return view
    }
    //  위의 주소값 가져오기 대신 id의 주소값 이용하려면 아래에서 해야함
    // Fragment가 관리하는 View 내부의 View의 주소값들이 세팅된 후
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        fragbtn1.setOnClickListener { 
            fragtext1.text = "Fragment 문자열"
        }

        fragbtn2.setOnClickListener {

            //MainActivity를 추출
            val parent = activity as MainActivity
            parent.activity_text1.text  = "Activity 문자열"
        }
   }
}