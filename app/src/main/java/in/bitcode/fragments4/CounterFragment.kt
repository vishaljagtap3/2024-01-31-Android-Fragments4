package `in`.bitcode.fragments2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import `in`.bitcode.fragments4.R

class CounterFragment : Fragment() {

    private lateinit var txtCount: TextView
    private lateinit var btnPlus: Button
    private lateinit var btnMinus: Button
    private lateinit var txtCounterFragmentTitle: TextView
    private lateinit var imgEdit: ImageView

    private var count = 0
        set(value) {
            field = value
            txtCount.text = "$value"
        }

    var title: String = "Counter"
        set(value) {
            field = value
            txtCounterFragmentTitle.text = value
        }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.counter_fragment, null)

        initViews(view)
        initListeners()

        return view
    }

    fun reset(count: Int = 0) {
        this.count = count
    }

    private fun initListeners() {
        btnPlus.setOnClickListener {
            //txtCount.text = "${++count}"
            ++count
        }

        btnMinus.setOnClickListener {
            //txtCount.text = "${--count}"
            --count
        }

        imgEdit.setOnClickListener {
            val textEditorDialog = TextEditorDialog(requireContext(), title)
            textEditorDialog.onTextSetListener =
                object : TextEditorDialog.OnTextSetListener {
                    override fun onTextSet(text: String) {
                        title = text
                    }
                }
            textEditorDialog.show()
        }
    }

    private fun initViews(view: View) {
        txtCount = view.findViewById(R.id.txtCount)
        btnMinus = view.findViewById(R.id.btnMinus)
        btnPlus = view.findViewById(R.id.btnPlus)
        txtCounterFragmentTitle = view.findViewById(R.id.txtCounterFragmentTitle)
        imgEdit = view.findViewById(R.id.imgEdit)

        txtCount.text = "$count"
    }

}