package com.example.miniproject_recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

//    private val dataArray = ArrayList<String>()
    private val  petList = arrayListOf<Pet>(
        Pet("british_shorthair","Male","4","british_shorthair"),
        Pet("persian_cat","FeMale","3","persian_cat"),
        Pet("siamese_cat","Male","2","siamese_cat"),
        Pet("maine_coon","FeMale","5","maine_coon"),
        Pet("ragdoll","FeMale","1","ragdoll"),
        Pet("sphynx_cat","Male","2","sphynx_cat"),
        Pet("abyssinian","Male","6","abyssinian")
)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        addDataArray()
        rv_data_list.layoutManager = LinearLayoutManager(this)
        rv_data_list.setHasFixedSize(true)
        rv_data_list.adapter = DataAdapter(petList,this){
            Toast.makeText(
                this, "breed : ${it.breed}, age : ${it.age}",
                Toast.LENGTH_LONG
            )
        }
    }


}

/*
1. 구성하기
 - 화면 레이아웃을 관리하는 LayoutManager
 - RecyclerView에 뷰를 놓을 ViewHolder
 - 데이터를 연결하는 Adapter
 */