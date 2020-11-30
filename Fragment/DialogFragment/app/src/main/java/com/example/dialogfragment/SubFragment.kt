package com.example.dialogfragment

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import kotlinx.android.synthetic.main.activity_main.*

class SubFragment : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val mainActivity = activity as MainActivity

        val builder = AlertDialog.Builder(mainActivity)
        builder.setTitle("타이틀")
        builder.setMessage("메시지")

        builder.setPositiveButton("Positive"){it,i ->
            mainActivity.textView.text="Positive"
        }

        builder.setNeutralButton("Neutral"){it, i ->
            mainActivity.textView.text="Neutral"

        }

        builder.setNegativeButton("Negative"){it, i ->
            mainActivity.textView.text="Negative"

        }

        val alert = builder.create()

        return alert

    }
}