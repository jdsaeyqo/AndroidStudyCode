package com.example.choicedialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val data1 = arrayOf(
        "항목1","항목2","항목3","항목4","항목5","항목6","항목7","항목8"
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            val builder = AlertDialog.Builder(this)

            builder.setTitle("Single Choice List")


            //3번 인덱스 버튼 누른채로 시작됨
            builder.setSingleChoiceItems(data1,3){it,i ->

                val t1 = Toast.makeText(this,data1[i], Toast.LENGTH_SHORT)
                t1.show()
            }

            builder.setNegativeButton("취소",null)

            //확인 버튼 눌렀을 때 리스너 설정
            builder.setPositiveButton("확인"){it, i ->
                val alert = it as AlertDialog

                val idx = alert.listView.checkedItemPosition

                textView.text ="선택된 항목 : ${data1[idx]}"

            }
            builder.show()
        }

        button2.setOnClickListener {
            val builder = AlertDialog.Builder(this)


            //선택된 상태로 시작하려면 선택하고 싶은체크박스 true로 설정 나머지 false인 booleanArray만들어야함
            val booleanArray = booleanArrayOf(true,false,false,true,false,false,false,false)

            //체크하고 풀 때 실행 리스너 설정
            builder.setMultiChoiceItems(data1,booleanArray){it, i, b ->

            if(b){
                val t1 = Toast.makeText(this,"${data1[i]}가 체크되었습니다.",Toast.LENGTH_SHORT)
                t1.show()
            }else{
                val t2 = Toast.makeText(this,"${data1[i]}가 체크 해제되었습니다",Toast.LENGTH_SHORT)
                t2.show()
            }

            }


            builder.setNegativeButton("취소",null)

            builder.setPositiveButton("확인"){it,i ->
                val alert = it as AlertDialog

                textView.text = ""

                val positions = alert.listView.checkedItemPositions

                for(i in 0 until  positions.size()){
                    //체크상태가 변경된 항목의 인덱스 번호를 추출
                    var index = positions.keyAt(i)

                    if(positions.get(index)){
                        textView.append("${data1[index]} ")
                    }
                }
            }

            builder.show()


        }
    }
}

/*
단일선택 Dialog
- 라디오 버튼 형태를 제공하는 다이얼로그
- AlertDialog에서 ListView를 추출하고 ListView의 checkedItemPosition프로퍼티를 이용해
선택한 항목의 인덱스 번호를 파악할 수 있다.

다중선택 Dialog
- checkbox 버튼 형태를 제공하는 다이얼로그
- AlertDialogBuilder에서 ListView를 추출하고 ListView의 checkedItemPositions프로퍼티를 이용해
  현재 선택된 항목들을 파악할 수 있다. 이 때, 선택 상태가 변경된 항목의 인덱스가 추출되므로
  이를 이용해 선택 여부를 직접 확인해야 한다
 */