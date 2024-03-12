package `in`.bitcode.fragments2

import android.app.Dialog
import android.content.Context
import android.widget.Button
import android.widget.EditText
import `in`.bitcode.fragments4.R

class TextEditorDialog(
    context: Context,
    var text : String = ""
) : Dialog(context) {

    private val edtText : EditText
    private val btnSetText : Button

    init {
        setContentView(R.layout.text_editor_dialog)
        edtText = findViewById(R.id.edtText)
        btnSetText = findViewById(R.id.btnSetText)
        edtText.setText(text)

        initListeners()
    }

    private fun initListeners() {
        btnSetText.setOnClickListener {
            if(onTextSetListener != null) {
                onTextSetListener!!.onTextSet(
                    edtText.text.toString()
                )
            }
            dismiss()
        }
    }

    interface OnTextSetListener {
        fun  onTextSet(text : String)
    }
    var onTextSetListener : OnTextSetListener? = null
}