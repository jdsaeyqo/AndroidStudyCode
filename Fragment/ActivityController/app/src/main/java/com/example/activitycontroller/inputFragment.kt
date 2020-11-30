package com.example.activitycontroller

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_input.*

class inputFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_input,null)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        input_button.setOnClickListener {
            val mainActivity = activity as MainActivity

            mainActivity.value1 = input1.text.toString()
            mainActivity.value2 = input2.text.toString()

            mainActivity.setFragment("result")
        }
    }

    override fun onResume() {
        super.onResume()
        input1.setText("")
        input2.setText("")
    }
}