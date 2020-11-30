package com.example.broadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class TestReciever : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        var str = "BroadCastReceiver가 동작하였습니다"
        val t1 = Toast.makeText(context,str,Toast.LENGTH_SHORT)
        t1.show()
        // manifest에서 이름 지정 해주어야 함
    }
}
