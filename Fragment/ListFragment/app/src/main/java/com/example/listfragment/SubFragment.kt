package com.example.listfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.ListFragment
import kotlinx.android.synthetic.main.fragment_sub.*

class SubFragment : ListFragment() {

    val data1= arrayOf("항목1","항목2","항목3","항목4","항목5","항목6")

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view= inflater.inflate(R.layout.fragment_sub,null)

        listAdapter = ArrayAdapter<String>(activity as MainActivity, android.R.layout.simple_list_item_1,data1)

        return view
    }
    //항목을 터치하면 호출되는 메서드
    override fun onListItemClick(l: ListView, v: View, position: Int, id: Long) {
        super.onListItemClick(l, v, position, id)

        sub_text1.text = data1[position]
    }
}