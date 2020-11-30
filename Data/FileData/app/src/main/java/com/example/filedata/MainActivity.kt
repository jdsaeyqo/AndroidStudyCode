package com.example.filedata

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import java.io.DataInputStream
import java.io.DataOutputStream
import java.io.FileInputStream
import java.io.FileOutputStream

class MainActivity : AppCompatActivity() {

    //내부 저장소의 앱 데이터 디렉토리의 경로
    lateinit var file_path : String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //null을 세팅하면 앱 데이터 폴더의 경로를 얻어오고
        //  Environment.DIRECTORY_종류 를 넣어주면 해당 경로를 얻어온다
        file_path = getExternalFilesDir(null).toString()
        Log.d("test",file_path)


        button.setOnClickListener {

            //MODE_PRIVATE : 덮어쓰기
            //MODE_APPEND : 이어쓰기
            val fos = openFileOutput("data1.dat",Context.MODE_PRIVATE)
            val dos = DataOutputStream(fos)
            //데이터를 쓴다
            dos.writeInt(100)
            dos.writeDouble(11.11)
            dos.writeBoolean(true)
            dos.writeUTF("문자열1")

            dos.flush()
            dos.close()

            textView.text = "내부 저장소 쓰기완료"
        }

        button2.setOnClickListener {
            val fis = openFileInput("data1.dat")
            val dis = DataInputStream(fis)

            val data1 = dis.readInt()
            val data2 = dis.readDouble()
            val data3 = dis.readBoolean()
            val data4 = dis.readUTF()

            dis.close()

            textView.text = "$data1\n"
            textView.append("$data2\n")
            textView.append("$data3\n")
            textView.append("$data4\n")
        }

        button3.setOnClickListener {
            val fos=FileOutputStream("$file_path/data2.dat")
            val dos=DataOutputStream(fos)
            dos.writeInt(200)
            dos.writeDouble(22.22)
            dos.writeBoolean(false)
            dos.writeUTF("문자열2")

            dos.flush()
            dos.close()

            textView.text = "외부 저장소의 앱 데이터 폴더에 저장"

        }

        button4.setOnClickListener {
            val fis = FileInputStream("$file_path/data2.dat")
            val dis = DataInputStream(fis)

            val data1 = dis.readInt()
            val data2 = dis.readDouble()
            val data3 = dis.readBoolean()
            val data4 = dis.readUTF()

            textView.text = "$data1\n"
            textView.append("$data2\n")
            textView.append("$data3\n")
            textView.append("$data4\n")
        }

        button5.setOnClickListener {
            //파일 관리 앱의 액티비티를 실행
            val fileIntent = Intent(Intent.ACTION_CREATE_DOCUMENT)
            fileIntent.addCategory(Intent.CATEGORY_OPENABLE)
            fileIntent.type = "*/*"
            startActivityForResult(fileIntent,100)
        }

        button6.setOnClickListener {
            //파일 관리 앱의 액티비티를 실행
            val fileIntent = Intent(Intent.ACTION_OPEN_DOCUMENT)
            fileIntent.type = "*/*"
            startActivityForResult(fileIntent,200)
        }


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 100){
            if (resultCode== RESULT_OK){
                val des1 = contentResolver.openAssetFileDescriptor(data?.data!!,"w")
                val fos = FileOutputStream(des1?.fileDescriptor)
                val dos = DataOutputStream(fos)
                dos.writeInt(400)
                dos.writeDouble(33.33)
                dos.writeBoolean(true)
                dos.writeUTF("문자열3")
                
                dos.flush()
                dos.close()
                
                textView.text = "다운로드 폴더에 저장"


            }
        }else if(requestCode == 200){
            if(resultCode == RESULT_OK){
                val des2 = contentResolver.openFileDescriptor(data?.data!!,"r")
                val fis = FileInputStream(des2?.fileDescriptor)
                val dis = DataInputStream(fis)

                val data1 = dis.readInt()
                val data2 = dis.readDouble()
                val data3 = dis.readBoolean()
                val data4 = dis.readUTF()

                dis.close()

                textView.text = "$data1\n"
                textView.append("$data2\n")
                textView.append("$data3\n")
                textView.append("$data4\n")

            }
        }
    }
}